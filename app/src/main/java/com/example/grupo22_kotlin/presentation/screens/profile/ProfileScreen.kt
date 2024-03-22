package com.example.grupo22_kotlin.presentation.screens.profile

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.MainActivity
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.navigation.BottomBarScreen
import com.example.grupo22_kotlin.presentation.navigation.Graph
import com.example.grupo22_kotlin.presentation.screens.profile.components.ProfileContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel= hiltViewModel()){


    Scaffold (
        topBar={},
        content={
            Column {
                ProfileContent(navController)



            }
            
        }
        )
}