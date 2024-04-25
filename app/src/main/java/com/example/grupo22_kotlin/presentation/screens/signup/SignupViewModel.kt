package com.example.grupo22_kotlin.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases
) : ViewModel() {
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

    var signupResponse by mutableStateOf<Response<FirebaseUser>?>(null)
        private set


    var user = User()
    fun onSignup() {
        username.value = username.value.trim()
        user.username = username.value
        user.email = email.value
        user.password = password.value
        user.number = number.value
        user.career = career.value

        signup(user)

    }

    fun signup(user: User) = viewModelScope.launch {
        signupResponse = Response.Loading
        val result = authUseCases.signup(user)
        signupResponse = result
    }


    fun createUser() = viewModelScope.launch {
        user.id = authUseCases.getCurrentUser()!!.uid
        userUseCases.create(user)
    }


    fun enabledLoginButton() {
        isEnabledLoginButton = isEmailValid.value &&
                isPasswordValid.value &&
                isUsernameValid.value &&
                isconfirmPasswordValid.value &&
                isnumberValid.value &&
                iscareerValid.value
    }


    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrMsg.value = ""
        } else {
            isEmailValid.value = false
            emailErrMsg.value = "That email is not valid"
        }
        enabledLoginButton()
    }


    fun validateUsername() {
        val usernameRegex = Regex("^[a-zA-Z0-9](.*[a-zA-Z0-9])?\$")
        val maxLength = 25

        if (username.value.trim().length >= 5 &&
            username.value.trim().length <= maxLength &&
            username.value.trim().matches(usernameRegex)
        ) {
            isUsernameValid.value = true
            usernameErrMsg.value = ""
        } else {
            isUsernameValid.value = false
            if (username.value.trim().length < 5) {
                usernameErrMsg.value = "At least 5 characters"
            } else if (username.value.trim().length > maxLength) {
                usernameErrMsg.value = "Maximum 25 characters"
            } else {
                usernameErrMsg.value = "Invalid characters or format"
            }
        }

        enabledLoginButton()
    }
    
    fun validatePassword() {
        if (password.value.length >= 6) {
            isPasswordValid.value = true
            passwordErrMsg.value = ""
        } else {
            isPasswordValid.value = false

            passwordErrMsg.value = "That Password must have at least 6 characters"


        }

        enabledLoginButton()
    }

    fun validateConfirmPasword() {
        if (password.value == confirmPassword.value) {
            isconfirmPasswordValid.value = true
            confirmPasswordErrMsg.value = ""
        } else {
            isconfirmPasswordValid.value = false
            confirmPasswordErrMsg.value = "That Password are not equal"
        }

        enabledLoginButton()
    }


    fun validateNumber() {
        if (number.value.length >= 10) {
            isnumberValid.value = true
            numberErrMsg.value = ""
        } else {
            isnumberValid.value = false

            numberErrMsg.value = "That number must be 10 characters long"

        }

        enabledLoginButton()
    }

    fun validateCareer() {
        if (career.value.length >= 1) {
            iscareerValid.value = true
            careerErrMsg.value = ""
        } else {
            iscareerValid.value = false
            careerErrMsg.value = "That career must not be empty"
        }

        enabledLoginButton()
    }


}