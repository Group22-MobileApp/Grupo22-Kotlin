package com.example.grupo22_kotlin.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {

    fun logout(){
        authUseCases.logOut()
    }
}