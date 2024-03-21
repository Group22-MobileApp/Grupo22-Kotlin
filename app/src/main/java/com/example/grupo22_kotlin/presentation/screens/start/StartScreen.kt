package com.example.grupo22_kotlin.presentation.screens.start

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.screens.start.components.StartContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavHostController){
    Scaffold(
        topBar = {},
        content = {

                StartContent(navController)
        },
        bottomBar = {}
    )
}




