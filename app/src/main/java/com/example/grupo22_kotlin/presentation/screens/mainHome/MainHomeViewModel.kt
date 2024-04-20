package com.example.grupo22_kotlin.presentation.screens.mainHome

import android.content.Context
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.posts.PostUseCases
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainHomeViewModel @Inject constructor(
    private val context: Context
    //TODO esa warning no creo que sea por buena practica
): ViewModel() {

    private lateinit var connectivityObserver: ConnectivityObserver

    fun getShit() {
        val connectivityObserver = NetworkConnectivityObserver(context.applicationContext)
    }
}

