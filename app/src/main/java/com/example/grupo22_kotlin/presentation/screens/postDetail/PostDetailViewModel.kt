package com.example.grupo22_kotlin.presentation.screens.postDetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.posts.PostUseCases
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userUseCases: UserUseCases,
    private val authUseCases: AuthUseCases,
    private val postUseCases: PostUseCases
): ViewModel() {



    val data = savedStateHandle.get<String>("post")
    val post = Post.fromJson(data!!)
    val currentUser = authUseCases.getCurrentUser()

    var addContactResponse by mutableStateOf<Response<Boolean>?>(null)
    var likePostResponse by mutableStateOf<Response<Boolean>?>(null)
    var deleteLikePostResponse by mutableStateOf<Response<Boolean>?>(null)

    fun addContact(idAddContact: String) = viewModelScope.launch {
        addContactResponse = Response.Loading
        val result = userUseCases.addContact(currentUser?.uid?: "", idAddContact)
        addContactResponse = result
    }

    fun like(idPost: String , idUser: String ) = viewModelScope.launch {
        likePostResponse = Response.Loading
        val result = postUseCases.likePost(idPost, idUser)
        likePostResponse = result
    }

    fun deletelike(idPost: String , idUser: String ) = viewModelScope.launch {
        deleteLikePostResponse = Response.Loading
        val result = postUseCases.deleteLikePost(idPost, idUser)
        deleteLikePostResponse = result
    }
}