package com.example.grupo22_kotlin.presentation.screens.profile_edit

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.screens.profile_edit.components.ProfileEditContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(
    navController: NavHostController,
    user: String
) {
    Log.d("ProfileEditScreen", "Usuario: $user")

    Scaffold(
        topBar = {

        },
        content = {
            ProfileEditContent(navController = navController)
        },
        bottomBar = {}
    )

}