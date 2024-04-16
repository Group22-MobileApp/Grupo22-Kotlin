package com.example.grupo22_kotlin.presentation.screens.postDetail

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.screens.login.components.Login
import com.example.grupo22_kotlin.presentation.screens.login.components.LoginContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostDetailScreen(navController: NavHostController) {


    Scaffold(
        topBar = {},
        content = {
            LoginContent(navController)
        },
        bottomBar = {}

    )
}
