package com.example.grupo22_kotlin.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(): ViewModel() {
    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrMsg: MutableState<String> = mutableStateOf("")


    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isconfirmPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrMsg: MutableState<String> = mutableStateOf("")


    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")


    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")

    var career: MutableState<String> = mutableStateOf("")
    var iscareerValid: MutableState<Boolean> = mutableStateOf(false)
    var careerErrMsg: MutableState<String> = mutableStateOf("")

    var number: MutableState<String> = mutableStateOf("")
    var isnumberValid: MutableState<Boolean> = mutableStateOf(false)
    var numberErrMsg: MutableState<String> = mutableStateOf("")


    var isEnabledLoginButton = false



    fun enabledLoginButton(){
        isEnabledLoginButton = isEmailValid.value &&
                isPasswordValid.value &&
                isUsernameValid.value &&
                isconfirmPasswordValid.value &&
                isnumberValid.value &&
                iscareerValid.value
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


    fun validateUsername(){
        if (username.value.length >= 5){
            isUsernameValid.value=true
            usernameErrMsg.value =""
        }
        else{
            isUsernameValid.value=false
            usernameErrMsg.value ="At least 5 caracters"
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

    fun validateConfirmPasword(){
        if (password.value == confirmPassword.value){
            isconfirmPasswordValid.value=true
            confirmPasswordErrMsg.value =""
        }
        else{
            isconfirmPasswordValid.value=false
            confirmPasswordErrMsg.value ="That Password are not equal"
        }

        enabledLoginButton()
    }


    fun validateNumber(){
        if (number.value.length >= 10){
            isnumberValid.value=true
            numberErrMsg.value =""
        }
        else{
            isnumberValid.value=false
            numberErrMsg.value ="That number is not valid"
        }

        enabledLoginButton()
    }

    fun validateCareer(){
        if (career.value.length >= 0){
            iscareerValid.value=true
            careerErrMsg.value =""
        }
        else{
            iscareerValid.value=false
            careerErrMsg.value ="That career must not be null"
        }

        enabledLoginButton()
    }




}