package com.example.grupo22_kotlin.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.grupo22_kotlin.presentation.screens.login.components.Login
import com.example.grupo22_kotlin.presentation.screens.login.components.LoginContent
import com.example.grupo22_kotlin.presentation.screens.signup.SignupScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavHostController) {


    Scaffold(
        topBar = {},
        content = {
            LoginContent(navController)
        },
        bottomBar = {}

    )
    Login(navController = navController)
}

