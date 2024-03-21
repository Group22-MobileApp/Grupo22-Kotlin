package com.example.grupo22_kotlin.presentation.screens.login

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {

    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")


    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")


    var isEnabledLoginButton = false

    private  val _loginflow =  MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> = _loginflow
    fun login() = viewModelScope.launch{
        _loginflow.value = Response.Loading
       val result = authUseCases.login(email.value, password.value)
        _loginflow.value = result
    }

    fun enabledLoginButton(){
        isEnabledLoginButton = isEmailValid.value && isPasswordValid.value
    }
    fun validateEmail(){
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
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
        if (password.value.length >= 6){
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