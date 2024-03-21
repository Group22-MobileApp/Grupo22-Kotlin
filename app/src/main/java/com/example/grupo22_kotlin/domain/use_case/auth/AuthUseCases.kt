package com.example.grupo22_kotlin.domain.use_case.auth

data class AuthUseCases (

    val getCurrentUser: GetCurrentUser,
    val login: Login,
    val logOut: LogOut,
    val signup: Signup
)