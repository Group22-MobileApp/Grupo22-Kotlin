package com.example.grupo22_kotlin.presentation.screens.profile_edit

import android.net.Uri
import android.util.Patterns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
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
class ProfileEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userUseCases: UserUseCases
) : ViewModel() {

    val data = savedStateHandle.get<String>("user")

    val user = User.fromJson(data!!)
    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrMsg: MutableState<String> = mutableStateOf("")


    var career: MutableState<String> = mutableStateOf("")
    var iscareerValid: MutableState<Boolean> = mutableStateOf(false)
    var careerErrMsg: MutableState<String> = mutableStateOf("")

    var number: MutableState<String> = mutableStateOf("")
    var isnumberValid: MutableState<Boolean> = mutableStateOf(false)
    var numberErrMsg: MutableState<String> = mutableStateOf("")


    var isEnabledActualizarDatos by mutableStateOf(false)

    var imageUri by mutableStateOf<Uri?>(null)
    var hasImage by mutableStateOf(false)


    fun onCameraResult(result: Boolean){
        hasImage= result
    }

    fun onResult(uri: Uri){
        hasImage= uri != null
        imageUri = uri
    }



    init {
        username.value = user.username
        number.value = user.number
        career.value = user.career
        validateUsername()
        validateNumber()
        validateCareer()

    }

    var updateResponse by  mutableStateOf<Response<Boolean>?>(null)
        private set

    fun onUpdate(){
        val myUser = User(
            id = user.id,
            username = username.value,
            image = "",
            career =  career.value,
            number = number.value
        )
        update(myUser)
    }

    fun update(user: User) = viewModelScope.launch {
        updateResponse = Response.Loading
        val result = userUseCases.update(user)
        updateResponse = result
    }



    fun enabledLoginButton() {
        isEnabledActualizarDatos =
                isUsernameValid.value &&
                isnumberValid.value && iscareerValid.value
    }




    fun validateUsername() {
        if (username.value.length >= 5) {
            isUsernameValid.value = true
            usernameErrMsg.value = ""
        } else {
            isUsernameValid.value = false
            usernameErrMsg.value = "At least 5 caracters"
        }

        enabledLoginButton()
    }

    fun validateNumber() {
        if (number.value.length >= 10) {
            isnumberValid.value = true
            numberErrMsg.value = ""
        } else {
            isnumberValid.value = false
            numberErrMsg.value = "That number is not valid"
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