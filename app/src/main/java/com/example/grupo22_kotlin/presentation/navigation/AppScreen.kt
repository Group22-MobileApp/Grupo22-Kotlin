package com.example.grupo22_kotlin.presentation.navigation

sealed class AppScreen(val route: String){
    object Start: AppScreen("start")
    object Signup: AppScreen("signup")

    object Login: AppScreen("login")
}