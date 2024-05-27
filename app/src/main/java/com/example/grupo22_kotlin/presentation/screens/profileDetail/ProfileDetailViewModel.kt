package com.example.grupo22_kotlin.presentation.screens.profileDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.grupo22_kotlin.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel(){
    val data = savedStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

}