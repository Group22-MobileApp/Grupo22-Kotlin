package com.example.grupo22_kotlin.presentation.screens.mainHome

import android.content.Context
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
@HiltViewModel
class MainHomeViewModel @Inject constructor(
    @ApplicationContext private val context: Context
): ViewModel() {

    val connectivityObserver = NetworkConnectivityObserver(context.applicationContext)

}

