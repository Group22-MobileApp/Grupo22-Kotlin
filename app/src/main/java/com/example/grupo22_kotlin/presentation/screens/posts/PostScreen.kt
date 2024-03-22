package com.example.grupo22_kotlin.presentation.screens.posts

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.screens.posts.components.GetPosts

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostsScreen(navController: NavHostController, viewModel: PostViewModel = hiltViewModel()) {

    Scaffold(
        content = {
            GetPosts(navController)
        }
    )

}