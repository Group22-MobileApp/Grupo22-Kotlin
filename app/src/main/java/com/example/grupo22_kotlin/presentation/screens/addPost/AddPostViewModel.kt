package com.example.grupo22_kotlin.presentation.screens.addPost

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddPostViewModel @Inject constructor(): ViewModel() {

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

    var isEnabledCheckYes = true
    var isEnabledCheckNo = true
    var isEnabledCheckNew = true
    var isEnabledCheckUsed = true

    fun enabledLoginButton() {
        isEnabledPostButton = isNameValid.value &&
                isPriceValid.value &&
                isDescriptionValid.value &&
                isCategoryValid.value &&
                (isEnabledCheckNew || isEnabledCheckUsed) &&
                (isEnabledCheckYes || isEnabledCheckNo)
    }

    fun validateName() {
        if (name.value.length >= 5) {
            isNameValid.value = true
            nameErrMsg.value = ""
        } else {
            isNameValid.value = false
            nameErrMsg.value = "A name needs at least 5 characters"
        }

        enabledLoginButton()
    }

    fun validatePrice() {
        if (price.value.length > 1) {
            isPriceValid.value = true
            priceErrMsg.value = ""
        } else {
            isPriceValid.value = false
            priceErrMsg.value = "More than a Number"
        }

        enabledLoginButton()
    }

    fun validateDescription() {
        if (description.value.length >= 6) {
            isDescriptionValid.value = true
            descriptionErrMsg.value = ""
        } else {
            isDescriptionValid.value = false
            descriptionErrMsg.value = "A description needs at least 6 characters"
        }

        enabledLoginButton()
    }
    fun validateCategory() {
        if (category.value.length >= 1) {
            isCategoryValid.value = true
            categoryErrMsg.value = ""
        } else {
            isCategoryValid.value = false
            category.value = "That career must not be empty"
        }

        enabledLoginButton()
    }
}