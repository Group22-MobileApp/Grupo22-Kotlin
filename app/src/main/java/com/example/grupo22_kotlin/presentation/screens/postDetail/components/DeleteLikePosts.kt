package com.example.grupo22_kotlin.presentation.screens.postDetail.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.screens.postDetail.PostDetailViewModel

@Composable
fun DeleteLikePost( viewModel: PostDetailViewModel = hiltViewModel()) {

    when(val response = viewModel.deleteLikePostResponse) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Response.Loading -> {
            Log.d("DeleteLikePost", "se esta realizando")

        }
        is Response.Success -> {
            Log.d("DeleteLikePost", "se Logro")
        }

        is Response.Failure -> {
            Toast.makeText(LocalContext.current,
                response.exception?.message ?: "Somethings wrong",
                Toast.LENGTH_LONG).show()
        }
        else -> {}
    }

}