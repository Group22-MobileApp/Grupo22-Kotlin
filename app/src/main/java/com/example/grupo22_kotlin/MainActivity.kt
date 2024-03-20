package com.example.grupo22_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grupo22_kotlin.ui.theme.Grupo22KotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Grupo22KotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.control),
                            contentDescription = "Control de xbox 360" )
                    }
                }
            }
        }
    }
}



@Composable
fun BodyContent(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
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
        Text(
            modifier = Modifier.padding(top = 30.dp),
            text = "LOGIN"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Pro favor inicia sesion para  continuar"
        )
        Spacer(modifier = Modifier.height(25.dp))
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Correo Electronico")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Contraseña")
            }
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

        Row() {
        Text(
            text = "No tienes cuenta ?",
            fontSize = 14.sp,
            color = Color.Gray
        )
            Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = "REGISTRATE AQUI",
            fontSize = 16.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Lisan Algaid testing $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Grupo22KotlinTheme {
        BodyContent()
    }
}