package com.example.grupo22_kotlin.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.DefaultTextField

@Composable
fun LoginContent(){
    Column(
        modifier = Modifier
            .fillMaxWidth()


    ) {

        Boxheader()
        LoginCard()





    }
}

@Composable
fun Boxheader(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .background(Color.Red)
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier =  Modifier.height(130.dp),
                painter = painterResource(id = R.drawable.control),
                contentDescription = "Control de xbox 360"
            )
            Text(
                text = "FIREBASE MVVM"
            )
        }

    }
}

@Composable
fun LoginCard(){

    var email by remember {
        mutableStateOf(value="")
    }

    var password by remember {
        mutableStateOf(value="")
    }

    Card(
        modifier = Modifier.padding(start=40.dp , end =40.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {


            Text(
                modifier = Modifier.padding(top = 30.dp),
                text = "LOGIN"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Pro favor inicia sesion para  continuar"
            )
            Spacer(modifier = Modifier.height(25.dp))
            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = "email",
                onValueChange ={email = it} ,
                label = "Email",
                icon = Icons.Default.Email,
                keyboardType = KeyboardType.Email)
            Spacer(modifier = Modifier.height(10.dp))
            DefaultTextField(
                modifier = Modifier.padding(top = 25.dp),
                value = "password",
                onValueChange ={password = it} ,
                label = "Contraseña",
                icon = Icons.Default.Lock,
                hideText = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 15.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "INICIAR SESION")
            }
        }
    }
}
