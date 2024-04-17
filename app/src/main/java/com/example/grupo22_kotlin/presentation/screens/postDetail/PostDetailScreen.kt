package com.example.grupo22_kotlin.presentation.screens.postDetail

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.presentation.screens.postDetail.components.PostDetailContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostDetailScreen(navController: NavHostController, post: String) {


    Scaffold(
        topBar = {},
        content = {
            PostDetailContent(navController)
        },
        bottomBar = {}

    )
}
