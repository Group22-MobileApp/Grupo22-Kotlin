package com.example.grupo22_kotlin.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.grupo22_kotlin.presentation.screens.login.LoginScreen
import com.example.grupo22_kotlin.presentation.screens.signup.SignupScreen
import com.example.grupo22_kotlin.presentation.screens.start.StartScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Start.route
    ) {

        composable(route = AuthScreen.Start.route) {
            StartScreen(navController)
        }

        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)
        }

        composable(route = AuthScreen.Signup.route) {
            SignupScreen(navController)
        }

    }
}

sealed class AuthScreen(val route: String) {

    object Start: AuthScreen("start")
    object Login: AuthScreen("login")
    object Signup: AuthScreen("signup")

}