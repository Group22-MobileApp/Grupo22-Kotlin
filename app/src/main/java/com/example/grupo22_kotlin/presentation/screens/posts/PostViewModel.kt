package com.example.grupo22_kotlin.presentation.screens.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.posts.PostUseCases
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postsUseCases: PostUseCases,
    private val authUseCases: AuthUseCases,
    private val  userCurrent: UserUseCases
): ViewModel() {

    var postsResponse by mutableStateOf<Response<List<Post>>?>(null)
    var postForYouResponse by mutableStateOf<Response<List<Post>>?>(null)
    var postCategory by mutableStateOf<Response<List<Post>>?>(null)
    var updateViews by mutableStateOf<Response<Boolean>?>(null)


    val currentUser = authUseCases.getCurrentUser()
    var userData by mutableStateOf(User())
        private set



    var postData by mutableStateOf(Post())
        private set

    init {
        getPosts()
        getPostsByUserTaste()
        getPostsByCategory("Miscellaneous")
    }

    fun getPosts() = viewModelScope.launch {
        postsResponse = Response.Loading
        postsUseCases.getPosts().collect() { response ->
            postsResponse = response
        }
    }

    fun getPostsByUserTaste() = viewModelScope.launch {
        postForYouResponse = Response.Loading
        userCurrent.getUserById(currentUser!!.uid).collect(){
            userData = it
            postsUseCases.getPostsByUserTaste(userData.career).collect() { response ->
                postForYouResponse = response
            }
        }
    }

    fun getPostsByCategory(category: String) = viewModelScope.launch {
        postCategory = Response.Loading //PostCategoryResponse
        postsUseCases.getPostsByCategory(category).collect() { response ->
            postCategory = response

        }
    }

    fun updateViews(idPost: String, newViews: String) = viewModelScope.launch {
        val viewsAsInt: Int = newViews.toInt()
        val updatedViews: Int = viewsAsInt + 1
        val updatedViewsString: String = updatedViews.toString()

        updateViews = Response.Loading
        val result = postsUseCases.updateViews(idPost, updatedViewsString)
        updateViews = result
    }

    /*fun getPostsByUserTaste() = viewModelScope.launch {
        postsResponse = Response.Loading
        /*userCurrent.getUserById(currentUser!!.uid).collect(){
            userData = it
        }*/
        postsUseCases.getPostsByUserTaste("Arte").collect() { response ->
            postsResponse = response
        }
    }*/

}