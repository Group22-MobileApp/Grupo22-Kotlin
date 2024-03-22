package com.example.grupo22_kotlin.presentation.screens.posts

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
class PostViewModel @Inject constructor(
    private val postsUseCases: PostUseCases,
    private val authUseCases: AuthUseCases
): ViewModel() {

    var postsResponse by mutableStateOf<Response<List<Post>>?>(null)
    var currentUser = authUseCases.getCurrentUser()

    init {
        getPosts()
    }

    fun getPosts() = viewModelScope.launch {
        postsResponse = Response.Loading
        postsUseCases.getPosts().collect() { response ->
            postsResponse = response
        }
    }

}