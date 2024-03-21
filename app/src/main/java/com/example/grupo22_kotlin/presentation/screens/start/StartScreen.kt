package com.example.grupo22_kotlin.presentation.screens.start

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.grupo22_kotlin.presentation.screens.start.components.StartContent
import com.example.grupo22_kotlin.presentation.ui.theme.Grupo22KotlinTheme

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




