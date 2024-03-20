package com.example.grupo22_kotlin.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {},
        content = {
            Text(text = "Login Screen")
        },
        bottomBar = {}

    )
}