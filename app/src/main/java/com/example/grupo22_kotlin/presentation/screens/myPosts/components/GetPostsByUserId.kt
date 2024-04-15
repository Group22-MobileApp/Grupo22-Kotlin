package com.example.grupo22_kotlin.presentation.screens.myPosts.components

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.screens.myPosts.MyPostsViewModel

@Composable
fun GetPostsByUserId(navController: NavHostController, viewModel: MyPostsViewModel = hiltViewModel()) {

    when(val response = viewModel.postsResponse) {
        // MOSTRAR QUE SE ESTA REALIZANDO LA PETICION Y TODAVIA ESTA EN PROCESO
        Response.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.size(80.dp))
            }
        }
        is Response.Success -> {
            MyPostsContent(posts = response.data, viewModel)
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current,
                response.exception?.message ?: "Somethings wrong",
                Toast.LENGTH_LONG).show()
        }
        else -> {}

    }

}