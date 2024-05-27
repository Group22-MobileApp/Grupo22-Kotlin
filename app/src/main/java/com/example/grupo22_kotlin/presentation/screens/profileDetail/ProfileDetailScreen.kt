package com.example.grupo22_kotlin.presentation.screens.profileDetail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.screens.profileDetail.components.ProfileDetailContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileDetailScreen(
    navController: NavHostController,
    viewModel: ProfileDetailViewModel = hiltViewModel(),
    user: String
) {

    Scaffold(
        topBar = {},
        content = {
            Column {
                ProfileDetailContent(navController)
            }
        }
    )
}