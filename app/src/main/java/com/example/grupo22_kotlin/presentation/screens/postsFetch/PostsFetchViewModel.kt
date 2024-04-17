package com.example.grupo22_kotlin.presentation.screens.postsFetch

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.posts.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsFetchViewModel @Inject constructor(
    private val postsUseCases: PostUseCases,
    private val authUseCases: AuthUseCases
): ViewModel() {

    var postsResponse by mutableStateOf<Response<List<Post>>?>(null)
    var postsCategoryResponse by mutableStateOf<Response<List<Post>>?>(null)
    var deleteResponse by mutableStateOf<Response<Boolean>?>(null)
    val currentUser = authUseCases.getCurrentUser()

    var category: MutableState<String> = mutableStateOf("")
    var isCategoryValid: MutableState<Boolean> = mutableStateOf(false)
    var categoryErrMsg: MutableState<String> = mutableStateOf("")

    init {
        getPosts()
        getPostsByCategory("Textile and Crafts")
    }

    fun delete(idPost: String) = viewModelScope.launch {
        deleteResponse = Response.Loading
        val result = postsUseCases.deletePost(idPost)
        deleteResponse = result
    }

    fun getPosts() = viewModelScope.launch {
        postsResponse = Response.Loading
        postsUseCases.getPostsByUserId(currentUser?.uid ?: "").collect() { response ->
            postsResponse = response
        }
    }

    fun getPostsByCategory(category: String) = viewModelScope.launch {
        postsCategoryResponse = Response.Loading
        postsUseCases.getPostsByCategory(category).collect() { response ->
            postsCategoryResponse = response

        }
    }


}