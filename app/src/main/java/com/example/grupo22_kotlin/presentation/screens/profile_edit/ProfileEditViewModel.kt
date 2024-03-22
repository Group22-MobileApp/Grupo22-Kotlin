package com.example.grupo22_kotlin.presentation.screens.profile_edit

import android.content.Context
import android.net.Uri
import android.util.Patterns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import com.example.grupo22_kotlin.presentation.utils.ComposeFileProvider
import com.example.grupo22_kotlin.presentation.utils.ResultingActivityHandler
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userUseCases: UserUseCases,
    @ApplicationContext private val context: Context
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

    var image: MutableState<String> = mutableStateOf("")


    var isEnabledActualizarDatos by mutableStateOf(false)



    var file: File? = null

    val resultingActivitiHandler = ResultingActivityHandler()


    fun pickImage()= viewModelScope.launch{
        val result = resultingActivitiHandler.getContent("image/*")
        if (result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            image.value = result.toString()


        }

    }

    fun takePhoto()= viewModelScope.launch{
        val result = resultingActivitiHandler.takePicturePreview()
        if (result != null){
            image.value = ComposeFileProvider.getPathFromBitmap(context, result)
            file = File(image.value)
        }

    }



    init {
        username.value = user.username
        number.value = user.number
        career.value = user.career
        image.value = user.image
        validateUsername()
        validateNumber()
        validateCareer()

    }

    var updateResponse by  mutableStateOf<Response<Boolean>?>(null)
        private set

    var saveImageupdateResponse by  mutableStateOf<Response<String>?>(null)
        private set

    fun saveImage() = viewModelScope.launch {
        if(file != null){
            saveImageupdateResponse = Response.Loading
            val result = userUseCases.saveImage(file!!)
            saveImageupdateResponse = result

        }else{

            onUpdate(image.value)
        }

    }

    fun onUpdate(url: String){
        val myUser = User(
            id = user.id,
            username = username.value,
            image = url ,
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