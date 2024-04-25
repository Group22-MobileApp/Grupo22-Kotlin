package com.example.grupo22_kotlin.presentation.screens.addPost

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.posts.PostUseCases
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import com.example.grupo22_kotlin.presentation.utils.ComposeFileProvider
import com.example.grupo22_kotlin.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AddPostViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val postsUseCases: PostUseCases,
    private val authUseCases: AuthUseCases,
    private val  userCurrent: UserUseCases
): ViewModel() {

    var state by mutableStateOf(NewPostState())

    var name: MutableState<String> = mutableStateOf("")
    var isNameValid: MutableState<Boolean> = mutableStateOf(false)
    var nameErrMsg: MutableState<String> = mutableStateOf("")

    var price: MutableState<String> = mutableStateOf("")
    var isPriceValid: MutableState<Boolean> = mutableStateOf(false)
    var priceErrMsg: MutableState<String> = mutableStateOf("")

    var description: MutableState<String> = mutableStateOf("")
    var isDescriptionValid: MutableState<Boolean> = mutableStateOf(false)
    var descriptionErrMsg: MutableState<String> = mutableStateOf("")

    var category: MutableState<String> = mutableStateOf("")
    var isCategoryValid: MutableState<Boolean> = mutableStateOf(false)
    var categoryErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledPostButton = false

    var selectedOption1: MutableState<String> = mutableStateOf("")
    var isSelectedOption1Selected: MutableState<Boolean> = mutableStateOf(false)

    var selectedOption2: MutableState<String> = mutableStateOf("")
    var isSelectedOption2Selected: MutableState<Boolean> = mutableStateOf(false)

    var image: MutableState<String> = mutableStateOf("")

    //var state by mutableStateOf(NewPostState())

    // FILE
    var file: File? = null

    val resultingActivitiHandler = ResultingActivityHandler()

    val currentUser = authUseCases.getCurrentUser()

    /*val user = userCurrent.getUserById(currentUser!!.uid).collect(){
        userData = it
    }*/
    var userData by mutableStateOf(User())
        private set
    var createPostResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    fun createPost(post: Post) = viewModelScope.launch {
        createPostResponse = Response.Loading
        userCurrent.getUserById(currentUser!!.uid).collect(){
            userData = it

            post.userCarrer = userData.career
            val result = postsUseCases.create(post, file!!)
            createPostResponse = result
        }
    }

     fun onNewPost() {


        val post = Post(
            name = name.value,
            description = description.value,
            price = price.value,
            condition = selectedOption1.value,
            interchangeable = selectedOption2.value,
            category = category.value,
            idUser = currentUser?.uid ?: "",
            userCarrer = "Arte",
            views = "0"
        )
        createPost(post)
    }

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


    fun enabledAddPostButton() {
        isEnabledPostButton = isNameValid.value &&
                isPriceValid.value &&
                isDescriptionValid.value &&
                isCategoryValid.value
    }

    fun clearForm() {
        name.value =""
        category.value = ""
        description.value = ""
        price.value = ""
        selectedOption1.value = ""
        selectedOption2.value = ""
        createPostResponse = null
    }

    fun validateName() {
        if (name.value.length >= 5) {
            isNameValid.value = true
            nameErrMsg.value = ""
        } else {
            isNameValid.value = false
            nameErrMsg.value = "A name needs at least 5 characters"
        }

        enabledAddPostButton()
    }

    fun validatePrice() {
        if (price.value.length > 1) {
            isPriceValid.value = true
            priceErrMsg.value = ""
        } else {
            isPriceValid.value = false
            priceErrMsg.value = "More than a Number"
        }

        enabledAddPostButton()
    }

    fun validateDescription() {
        if (description.value.length >= 6) {
            isDescriptionValid.value = true
            descriptionErrMsg.value = ""
        } else {
            isDescriptionValid.value = false
            descriptionErrMsg.value = "A description needs at least 6 characters"
        }

        enabledAddPostButton()
    }
    fun validateCategory() {
        if (category.value.length >= 1) {
            isCategoryValid.value = true
            categoryErrMsg.value = ""
        } else {
            isCategoryValid.value = false
            category.value = "That career must not be empty"
        }

        enabledAddPostButton()
    }

    fun validateOption1(){
        if (selectedOption1.value != ""){
            isSelectedOption1Selected.value = true
        } else {
            isSelectedOption1Selected.value = false
        }
        enabledAddPostButton()
    }

    fun validateOption2(){
        if (selectedOption2.value != ""){
            isSelectedOption2Selected.value = true
        } else {
            isSelectedOption2Selected.value = false
        }
        enabledAddPostButton()
    }
}