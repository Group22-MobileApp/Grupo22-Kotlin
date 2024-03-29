package com.example.grupo22_kotlin.presentation.screens.mainHome

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.grupo22_kotlin.presentation.components.DefaultTopBar
import com.example.grupo22_kotlin.presentation.screens.mainHome.components.MainHomeContent
import com.example.grupo22_kotlin.presentation.screens.signup.SignupScreen
import com.example.grupo22_kotlin.presentation.screens.signup.components.SignupContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainHomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
        },
        content = {
            Column(modifier = Modifier.padding(top=55.dp)) {
                MainHomeContent(navController = navController)
            }
        },
        bottomBar = {}

    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainHomeScreen(){
    MainHomeScreen(rememberNavController())
}