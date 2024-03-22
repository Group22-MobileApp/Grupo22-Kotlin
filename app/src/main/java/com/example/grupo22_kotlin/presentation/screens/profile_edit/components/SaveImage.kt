package com.example.grupo22_kotlin.presentation.screens.profile_edit.components

import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.screens.profile_edit.ProfileEditViewModel

@Composable
fun SaveImage(viewModel: ProfileEditViewModel= hiltViewModel()){
    when(val response = viewModel.saveImageupdateResponse){
        Response.Loading->{
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.size(80.dp))
            }
        }
        is Response.Success ->{
            Toast.makeText(LocalContext.current,"User Update",Toast.LENGTH_SHORT).show()
            viewModel.onUpdate(response.data)
        }
        is Response.Failure->{
            Toast.makeText(LocalContext.current,response.exception?.message?: "Error desconocido", Toast.LENGTH_SHORT)
        }

        else -> {}
    }
}