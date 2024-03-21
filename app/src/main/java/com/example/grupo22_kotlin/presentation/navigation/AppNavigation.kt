package com.example.grupo22_kotlin.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grupo22_kotlin.presentation.screens.login.LoginScreen
import com.example.grupo22_kotlin.presentation.screens.profile.ProfileScreen

import com.example.grupo22_kotlin.presentation.screens.signup.SignupScreen
import com.example.grupo22_kotlin.presentation.screens.start.StartScreen

@Composable
fun AppNavigation(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = AppScreen.Start.route){
        composable(route= AppScreen.Start.route) {
            StartScreen(navController)
        }
        composable(route = AppScreen.Signup.route){
            SignupScreen(navController)
        }
        composable(route= AppScreen.Login.route){
            LoginScreen(navController)
        }

        composable(route= AppScreen.Profile.route){
            ProfileScreen(navController)
        }

    }




}