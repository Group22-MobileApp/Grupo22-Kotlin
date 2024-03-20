package com.example.grupo22_kotlin.presentation.screens.login.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.DefaultButton
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.navigation.AppScreen
import com.example.grupo22_kotlin.presentation.screens.login.LoginViewModel

@Composable
fun LoginContent(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()){





    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(100.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription ="Logo" )
        Text(
            modifier = Modifier.padding(15.dp),
            text = "Login"
        )
        Text(text = "Good to see you back")
        Spacer(modifier = Modifier.height(15.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.email.value,
            onValueChange ={viewModel.email.value = it} ,
            label = "Email",
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(15.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.password.value,
            onValueChange ={viewModel.password.value = it} ,
            label = "Password",
            hideText = true
        )
        Spacer(modifier = Modifier.height(15.dp))

        DefaultButton(modifier = Modifier, text = "Next", onClick = {
            Log.d("Logincontent", "Email: ${viewModel.email.value}")
        })
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Cancel")

    }
}

