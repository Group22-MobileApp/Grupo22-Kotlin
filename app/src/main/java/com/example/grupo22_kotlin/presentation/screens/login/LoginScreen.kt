package com.example.grupo22_kotlin.presentation.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.grupo22_kotlin.presentation.screens.login.components.LoginBottomBar
import com.example.grupo22_kotlin.presentation.screens.login.components.LoginContent
import com.example.grupo22_kotlin.presentation.ui.theme.Grupo22KotlinTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavHostController){
    Scaffold(
        topBar = {},
        content = {
                  LoginContent()
        },
        bottomBar = {
            LoginBottomBar(navController)

        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Grupo22KotlinTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(rememberNavController())
        }

    }
}