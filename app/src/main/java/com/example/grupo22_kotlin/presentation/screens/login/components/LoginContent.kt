package com.example.grupo22_kotlin.presentation.screens.login.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.components.DefaultButton
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.navigation.AppScreen
import com.example.grupo22_kotlin.presentation.screens.login.LoginViewModel

@Composable
fun LoginContent(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()){

 val loginFlow = viewModel.loginFlow.collectAsState()



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
        Spacer(modifier = Modifier.height(10.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.email.value,
            onValueChange ={viewModel.email.value = it} ,
            label = "Email",
            keyboardType = KeyboardType.Email,
            errorMsg = viewModel.emailErrMsg.value,
            validateField = {
                viewModel.validateEmail()
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.password.value,
            onValueChange ={viewModel.password.value = it} ,
            label = "Password",
            hideText = true,
            errorMsg = viewModel.passwordErrMsg.value,
            validateField = {
                viewModel.validatePassword()
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        DefaultButton(modifier = Modifier,
            text = "Next",
            onClick = {
                      viewModel.login()
            },
            enabled = viewModel.isEnabledLoginButton)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Cancel")

    }
    loginFlow.value.let { 
        when(it){
            Response.Loading->{
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                    ){
                    CircularProgressIndicator()
                }
            }
            is Response.Success ->{
                LaunchedEffect( Unit ) {
                    navController.navigate(route = AppScreen.Profile.route)
                }
                Toast.makeText(LocalContext.current, "Usuario logeado", Toast.LENGTH_LONG).show()
            }
            is Response.Failure->{
                Toast.makeText(LocalContext.current, it.exception?.message ?:"Error desconocido", Toast.LENGTH_LONG).show()
            }
            else ->{}
        }
    }
}

