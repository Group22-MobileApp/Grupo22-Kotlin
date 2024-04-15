package com.example.grupo22_kotlin.presentation.screens.start.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.components.ForwardButton
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.components.Logo
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.navigation.Graph
import com.example.grupo22_kotlin.presentation.screens.start.StartViewModel
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue


@Composable
fun StartContent(navController: NavHostController, viewModel: StartViewModel = hiltViewModel()) {
    val loginFlow = viewModel.loginFlow.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LandingBody(modifier = Modifier.weight(3f))
        LandingFooter(modifier = Modifier.weight(1f), navController)
    }
    loginFlow.value.let {
        when(it){
            is Response.Success ->{
                LaunchedEffect( Unit ) {
                    navController.navigate(route = Graph.HOME){
                        popUpTo(Graph.AUTHENTICATION){inclusive= true}
                    }
                }
                Toast.makeText(LocalContext.current, "Usuario logeado", Toast.LENGTH_LONG).show()
            }
            else ->{}
        }
    }
}

@Composable
fun LandingBody(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Logo(modifier = Modifier, width = 165.dp, height = 165.dp )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Goat's Mart".uppercase(),
            textAlign = TextAlign.Center,
            color = darkBlue,
            fontSize = 45.sp,
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = "Uniandes store by students for students",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            lineHeight = 33.sp,
            modifier = Modifier.width(250.dp)
        )
    }
}

@Composable
fun LandingFooter(modifier: Modifier, navController: NavHostController) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImportantButton(
            modifier = Modifier,
            text = "Let's get started",
            onClick = { navController.navigate(route = AuthScreen.Signup.route) })

        Spacer(modifier = Modifier.padding(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "I already have an account")

            Spacer(modifier = Modifier.padding(4.dp))

            ForwardButton(
                modifier = Modifier,
                onClick = { navController.navigate(route = AuthScreen.Login.route) })
        }
    }
}