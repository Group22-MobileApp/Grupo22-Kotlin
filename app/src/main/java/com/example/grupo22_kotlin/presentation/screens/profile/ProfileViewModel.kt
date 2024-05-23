package com.example.grupo22_kotlin.presentation.screens.profile

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import com.example.grupo22_kotlin.presentation.screens.mainHome.NetworkConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val connectivityObserver = NetworkConnectivityObserver(context.applicationContext)

    val currentUser = authUseCases.getCurrentUser()
    var userData by mutableStateOf(User())
        private set


    init {
        getUserById()
    }

    private fun getUserById() = viewModelScope.launch {
        userUseCases.getUserById(currentUser!!.uid).collect() {
            userData = it
        }
    }

    fun logout() {
        authUseCases.logOut()
    }


}