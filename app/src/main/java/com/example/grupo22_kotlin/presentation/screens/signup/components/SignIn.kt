package com.example.grupo22_kotlin.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.navigation.Graph
import com.example.grupo22_kotlin.presentation.screens.signup.SignupViewModel


@Composable
fun SignIn(navController: NavHostController , viewModel: SignupViewModel = hiltViewModel()){
    when (val signupRespposne = viewModel.signupResponse) {
        Response.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.size(80.dp))
            }
        }

        is Response.Success -> {
            LaunchedEffect(Unit) {
                viewModel.createUser()
                navController.navigate(route = Graph.HOME) {
                    popUpTo(Graph.AUTHENTICATION) { inclusive = true }
                }
            }
            Toast.makeText(LocalContext.current, "Usuario creado", Toast.LENGTH_SHORT).show()
        }

        is Response.Failure -> {
            Toast.makeText(
                LocalContext.current,
                signupRespposne.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        else -> {}
    }
}