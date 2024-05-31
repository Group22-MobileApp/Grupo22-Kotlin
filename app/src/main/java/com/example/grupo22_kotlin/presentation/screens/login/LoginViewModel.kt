package com.example.grupo22_kotlin.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {

    var email by mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")


    var password by  mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")


    var isEnabledLoginButton = false



    val currentUser = authUseCases.getCurrentUser()

    var loginResponse by mutableStateOf<Response<FirebaseUser>?>(null)

    init {
        if(currentUser != null) {
            loginResponse = Response.Success(currentUser)
        }
    }


    fun login() = viewModelScope.launch{
        loginResponse= Response.Loading
       val result = authUseCases.login(email, password)
        loginResponse = result
    }

    fun enabledLoginButton(){
        isEnabledLoginButton = isEmailValid.value && isPasswordValid.value
    }
    fun validateEmail(){
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            isEmailValid.value=true
            emailErrMsg.value =""
        }
        else{
            isEmailValid.value=false
            emailErrMsg.value ="That email is not valid"
        }
        enabledLoginButton()
    }


    fun validatePassword(){
        if (password.length >= 6){
            isPasswordValid.value=true
            passwordErrMsg.value =""
        }
        else{
            isPasswordValid.value=false
            passwordErrMsg.value ="That Password is not valid"
        }

        enabledLoginButton()
    }



}