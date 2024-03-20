package com.example.grupo22_kotlin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grupo22_kotlin.presentation.screens.login.LoginScreen
import com.example.grupo22_kotlin.presentation.screens.signup.SignupScreen

@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route){
        composable(route= AppScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AppScreen.Signup.route){
            SignupScreen()
        }
    }




}