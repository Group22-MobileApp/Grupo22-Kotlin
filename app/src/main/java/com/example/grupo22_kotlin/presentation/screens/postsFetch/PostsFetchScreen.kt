package com.example.grupo22_kotlin.presentation.screens.postsFetch

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.screens.myPosts.components.GetPostsByUserId
import com.example.grupo22_kotlin.presentation.screens.posts.PostViewModel
import com.example.grupo22_kotlin.presentation.screens.postsFetch.components.PostFetchContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostsFetchScreen(postType: String, navController: NavHostController, viewModel: PostViewModel = hiltViewModel()) {

    Scaffold(
        content = {
            PostFetchContent(postType, viewModel, navController)
        }
    )

}
