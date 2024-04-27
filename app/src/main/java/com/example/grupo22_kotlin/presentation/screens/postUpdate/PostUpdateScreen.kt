package com.example.grupo22_kotlin.presentation.screens.postUpdate

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.screens.postDetail.components.PostDetailContent
import com.example.grupo22_kotlin.presentation.screens.postUpdate.components.PostUpdateContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostUpdateScreen(navController: NavHostController, post: String) {


    Scaffold(
        topBar = {},
        content = {
            PostUpdateContent(navController)
        },
        bottomBar = {}

    )
}