package com.example.grupo22_kotlin.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.DefaultButton
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.navigation.AppScreen

@Composable
fun LoginContent(navController: NavHostController){
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
        DefaultTextField(modifier = Modifier, value = "Uniandes email ", onValueChange ={it} , label = "Email")
        Spacer(modifier = Modifier.height(15.dp))
        DefaultTextField(modifier = Modifier, value = "Password", onValueChange ={it} , label = "Email")
        Spacer(modifier = Modifier.height(15.dp))
        DefaultButton(modifier = Modifier, text = "Next", onClick = { navController.navigate(route = AppScreen.Signup.route) })
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Cancel")

    }
}