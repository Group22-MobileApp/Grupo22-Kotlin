package com.example.grupo22_kotlin.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val authUseCases: AuthUseCases): ViewModel() {
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

    private  val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Response<FirebaseUser>?> = _signupFlow
    
    fun onSignup(){
        val user = User(
            username = username.value,
            email = email.value,
            password = password.value,
            number = number.value,
            career = career.value

        )

        signup(user)

    }
    fun signup(user: User) = viewModelScope.launch {
        _signupFlow.value= Response.Loading
        val result = authUseCases.signup(user)
        _signupFlow.value= result
    }



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