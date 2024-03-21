package com.example.grupo22_kotlin.presentation.screens.start

import androidx.lifecycle.ViewModel
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val authUseCases: AuthUseCases):ViewModel(){

    private  val _loginflow =  MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> = _loginflow

    val currentUser = authUseCases.getCurrentUser()

    init {
        if(currentUser != null) {
            _loginflow.value = Response.Success(currentUser)
        }
    }


}