package com.example.grupo22_kotlin.presentation.screens.postDetail.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.screens.postDetail.PostDetailViewModel

@Composable
fun LikePost( viewModel: PostDetailViewModel = hiltViewModel()) {

    when(val response = viewModel.likePostResponse) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Response.Loading -> {

        }
        is Response.Success -> {

        }

        is Response.Failure -> {
            Toast.makeText(LocalContext.current,
                response.exception?.message ?: "Somethings wrong",
                Toast.LENGTH_LONG).show()
        }
        else -> {}
    }

}