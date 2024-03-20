package com.example.grupo22_kotlin.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.grupo22_kotlin.presentation.navigation.AppScreen
import com.example.grupo22_kotlin.presentation.screens.login.components.LoginContent
import com.example.grupo22_kotlin.presentation.ui.theme.Grupo22KotlinTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavHostController){
    Scaffold(
        topBar = {},
        content = {
            Column {
                LoginContent(navController)

            }

        },
        bottomBar = {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetPreview(){
    Grupo22KotlinTheme(darkTheme = false){
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(rememberNavController() )
        }

    }
    }


