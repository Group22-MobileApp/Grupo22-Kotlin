package com.example.grupo22_kotlin.presentation.screens.mainHome

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
<<<<<<< HEAD
=======
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
>>>>>>> main
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.grupo22_kotlin.presentation.screens.mainHome.components.MainHomeContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainHomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
        },
        content = {
            MainHomeContent(navController = navController)
        },
        bottomBar = {}

    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainHomeScreen() {
    MainHomeScreen(rememberNavController())
}