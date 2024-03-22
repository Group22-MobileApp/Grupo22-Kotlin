package com.example.grupo22_kotlin.presentation.screens.login.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.components.Logo
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.navigation.BottomBarScreen
import com.example.grupo22_kotlin.presentation.navigation.Graph
import com.example.grupo22_kotlin.presentation.screens.login.LoginViewModel
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue

@SuppressLint("SuspiciousIndentation")
@Composable
fun LoginContent(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {

    Box(
        modifier = Modifier.paint(
            painter = painterResource(id = R.drawable.ic_bubbleslogin),
            contentScale = ContentScale.FillWidth
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginHeader(modifier = Modifier.weight(1f))
        LoginBody(
            modifier = Modifier.weight(1.2f),
            navController = navController,
            viewModel = viewModel
        )

    }
}

@Composable
fun LoginHeader(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(32.dp))
        Logo(modifier = Modifier, width = 115.dp, height = 115.dp)
    }
}

@Composable
fun LoginBody(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val loginFlow = viewModel.loginFlow.collectAsState()

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            textAlign = TextAlign.Start,
            color = darkBlue,
            fontSize = 50.sp,
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Good to see you back!", modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = "Email",
            keyboardType = KeyboardType.Email,
            errorMsg = viewModel.emailErrMsg.value,
            validateField = {
                viewModel.validateEmail()
            }
        )
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            label = "Password",
            hideText = true,
            errorMsg = viewModel.passwordErrMsg.value,
            validateField = {
                viewModel.validatePassword()
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        ImportantButton(
            modifier = Modifier,
            text = "Next",
            onClick = {
                viewModel.login()
            },
            enabled = viewModel.isEnabledLoginButton
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Cancel",
            modifier = Modifier.clickable {
                navController.navigate(route = AuthScreen.Start.route)
            }
        )
        Spacer(modifier = Modifier.padding(42.dp))

    }
    loginFlow.value.let {
        when (it) {
            Response.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.size(80.dp))
                }
            }

            is Response.Success -> {
                LaunchedEffect(Unit) {
                    navController.navigate(route = Graph.HOME) {
                        popUpTo(Graph.AUTHENTICATION) { inclusive = true }
                    }
                }
                Toast.makeText(LocalContext.current, "Usuario logeado", Toast.LENGTH_LONG).show()
            }

            is Response.Failure -> {
                Toast.makeText(
                    LocalContext.current,
                    it.exception?.message ?: "Error desconocido",
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> {}
        }
    }
}


