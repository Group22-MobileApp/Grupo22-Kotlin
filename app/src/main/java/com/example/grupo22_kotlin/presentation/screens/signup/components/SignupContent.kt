package com.example.grupo22_kotlin.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.screens.signup.SignupViewModel

@Composable
fun SignupContent(navController: NavHostController, viewModel: SignupViewModel= hiltViewModel()){
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
            text = "Create Account"
        )
        Spacer(modifier = Modifier.height(8.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.username.value,
            onValueChange ={viewModel.username.value =it} ,
            label = "Name",
            errorMsg = viewModel.usernameErrMsg.value,
            validateField = {viewModel.validateUsername()}
            )
        Spacer(modifier = Modifier.height(8.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.email.value,
            onValueChange ={viewModel.email.value =it} ,
            label = "Email",
            errorMsg = viewModel.emailErrMsg.value,
            validateField = {viewModel.validateEmail()},
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(8.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.password.value,
            onValueChange ={viewModel.password.value =it} ,
            label = "Password",
            errorMsg = viewModel.passwordErrMsg.value,
            validateField = {viewModel.validatePassword()},
            hideText = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.confirmPassword.value,
            onValueChange ={viewModel.confirmPassword.value =it} ,
            label = "Confirm Password",
            errorMsg = viewModel.confirmPasswordErrMsg.value,
            validateField = {viewModel.validateConfirmPasword()},
            hideText = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.number.value,
            onValueChange ={viewModel.number.value =it} ,
            label = "Phone number",
            errorMsg = viewModel.numberErrMsg.value,
            validateField = {viewModel.validateNumber()},
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(8.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.career.value,
            onValueChange ={viewModel.career.value =it} ,
            label = "Whats your career",
            errorMsg = viewModel.careerErrMsg.value,
            validateField = {viewModel.validateCareer()}
        )
        DefaultButton(modifier = Modifier,
            text = "DONE",
            onClick = { navController.navigate(route = AuthScreen.Login.route) },
            enabled = viewModel.isEnabledLoginButton)


    }
}