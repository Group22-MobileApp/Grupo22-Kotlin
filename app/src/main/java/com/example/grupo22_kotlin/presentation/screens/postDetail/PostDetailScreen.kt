package com.example.grupo22_kotlin.presentation.screens.postDetail

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.screens.postDetail.components.AddReviewPost
import com.example.grupo22_kotlin.presentation.screens.postDetail.components.DeleteLikePost
import com.example.grupo22_kotlin.presentation.screens.postDetail.components.GetReviewsByPost
import com.example.grupo22_kotlin.presentation.screens.postDetail.components.LikePost
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
    LikePost()
    DeleteLikePost()
    AddReviewPost()
    GetReviewsByPost()
}
