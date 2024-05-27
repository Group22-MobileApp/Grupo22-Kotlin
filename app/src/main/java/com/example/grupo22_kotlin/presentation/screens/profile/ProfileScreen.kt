package com.example.grupo22_kotlin.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.screens.profile.components.ProfileContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {

<<<<<<< HEAD
=======

>>>>>>> main
    Scaffold(
        topBar = {},
        content = {
            Column {
                ProfileContent(navController)
            }
        }
    )
}