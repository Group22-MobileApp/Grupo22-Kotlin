package com.example.grupo22_kotlin.presentation.screens.postUpdate

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
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
class PostUpdateViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val savedStateHandle: SavedStateHandle,
    private val authUseCases: AuthUseCases,
    private val  postUseCases: PostUseCases
): ViewModel() {

    var file: File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    val data = savedStateHandle.get<String>("post")
    val post = Post.fromJson(data!!)

    var updatePostResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    var image: MutableState<String> = mutableStateOf("")

    val currentUser = authUseCases.getCurrentUser()

    var name: MutableState<String> = mutableStateOf(post.name)
    var isNameValid: MutableState<Boolean> = mutableStateOf(false)
    var nameErrMsg: MutableState<String> = mutableStateOf("")

    var price: MutableState<String> = mutableStateOf(post.price)
    var isPriceValid: MutableState<Boolean> = mutableStateOf(false)
    var priceErrMsg: MutableState<String> = mutableStateOf("")

    var description: MutableState<String> = mutableStateOf(post.description)
    var isDescriptionValid: MutableState<Boolean> = mutableStateOf(false)
    var descriptionErrMsg: MutableState<String> = mutableStateOf("")

    var category: MutableState<String> = mutableStateOf(post.category)
    var isCategoryValid: MutableState<Boolean> = mutableStateOf(false)
    var categoryErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledPostButton = false

    var selectedOption1: MutableState<String> = mutableStateOf(post.condition)
    var isSelectedOption1Selected: MutableState<Boolean> = mutableStateOf(false)

    var selectedOption2: MutableState<String> = mutableStateOf(post.interchangeable)
    var isSelectedOption2Selected: MutableState<Boolean> = mutableStateOf(false)

    fun updatePost(post: Post) = viewModelScope.launch {
        updatePostResponse = Response.Loading
        val result = postUseCases.updatePost(post, file)
        updatePostResponse = result
    }
    fun onUpdatePost() {
        val post = Post(
            id = post.id,
            name = name.value,
            description = description.value,
            price = price.value,
            condition = selectedOption1.value,
            interchangeable = selectedOption2.value,
            category = category.value,
            image = post.image,
            idUser = currentUser?.uid ?: ""
        )
        updatePost(post)
    }

    init {
        enabledUpdateButton()
    }

    fun pickImage()= viewModelScope.launch{
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null){
            file = ComposeFileProvider.createFileFromUri(context, result)
            image.value = result.toString()
        }
    }

    fun takePhoto()= viewModelScope.launch{
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null){
            image.value = ComposeFileProvider.getPathFromBitmap(context, result)
            file = File(image.value)
        }
    }

    fun enabledUpdateButton() {
        isEnabledPostButton = isNameValid.value &&
                isPriceValid.value &&
                isDescriptionValid.value &&
                isCategoryValid.value
    }

    fun validateName() {
        if (name.value.length >= 5) {
            isNameValid.value = true
            nameErrMsg.value = ""
        } else {
            isNameValid.value = false
            nameErrMsg.value = "A name needs at least 5 characters"
        }

        enabledUpdateButton()
    }

    fun validatePrice() {
        if (price.value.length > 1) {
            isPriceValid.value = true
            priceErrMsg.value = ""
        } else {
            isPriceValid.value = false
            priceErrMsg.value = "More than a Number"
        }

        enabledUpdateButton()
    }

    fun validateDescription() {
        if (description.value.length >= 6) {
            isDescriptionValid.value = true
            descriptionErrMsg.value = ""
        } else {
            isDescriptionValid.value = false
            descriptionErrMsg.value = "A description needs at least 6 characters"
        }

        enabledUpdateButton()
    }
    fun validateCategory() {
        if (category.value.length >= 1) {
            isCategoryValid.value = true
            categoryErrMsg.value = ""
        } else {
            isCategoryValid.value = false
            category.value = "That career must not be empty"
        }

        enabledUpdateButton()
    }


}