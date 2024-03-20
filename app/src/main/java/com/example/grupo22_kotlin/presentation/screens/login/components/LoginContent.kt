package com.example.grupo22_kotlin.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.DefaultButton
import com.example.grupo22_kotlin.presentation.navigation.AppScreen

@Composable
fun LoginContent(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription ="Logo" )
        Text(
            modifier = Modifier.padding(15.dp),
            text = "GOAT´S MART"
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "Uniandes store by /n students to students")
        Spacer(modifier = Modifier.height(25.dp))
        DefaultButton(modifier = Modifier, text = "Lets get startet", onClick = { navController.navigate(route = AppScreen.Signup.route) })
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            modifier = Modifier
                .clickable { navController.navigate(route = AppScreen.Register.route) },
            text = "I alredy have an account")

    }
}