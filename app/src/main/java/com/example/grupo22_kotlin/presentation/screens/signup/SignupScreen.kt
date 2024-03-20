package com.example.grupo22_kotlin.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.grupo22_kotlin.presentation.components.DefaultTopBar
import com.example.grupo22_kotlin.presentation.screens.signup.components.SignupContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignupScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
                 DefaultTopBar(
                     title = "New User",
                     upAvailable = true,
                     navController = navController)

        },
        content = {
            Column(modifier = Modifier.padding(top=55.dp)) {
                SignupContent(navController = navController)
            }



        },
        bottomBar = {}

    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSigunScreen(){
    SignupScreen(rememberNavController())
}