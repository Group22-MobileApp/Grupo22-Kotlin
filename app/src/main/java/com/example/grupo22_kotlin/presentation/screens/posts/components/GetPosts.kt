package com.example.grupo22_kotlin.presentation.screens.posts.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.screens.posts.PostViewModel

@Composable
fun GetPosts(navController: NavHostController, viewModel: PostViewModel = hiltViewModel()) {

    when(val response = viewModel.postsResponse) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Response.Loading -> {

        }
        else -> {}
    }

}