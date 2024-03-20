package com.example.grupo22_kotlin.presentation.navigation

sealed class AppScreen(val route: String){
    object Login: AppScreen("login")
    object Signup: AppScreen("signup")

}