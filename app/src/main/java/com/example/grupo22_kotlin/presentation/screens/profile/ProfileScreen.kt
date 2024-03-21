package com.example.grupo22_kotlin.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navHostController: NavHostController){
    Scaffold (
        topBar={},
        content={
            Text(text = "Profile Screen")
        }
        )
}