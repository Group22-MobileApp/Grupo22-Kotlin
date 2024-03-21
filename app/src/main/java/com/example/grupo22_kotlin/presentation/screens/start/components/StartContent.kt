package com.example.grupo22_kotlin.presentation.screens.start.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.ui.theme.Montserrat
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue


@Composable
fun StartContent(navController: NavHostController) {
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
}

@Composable
fun LandingBody(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .width(165.dp)
                .height(165.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_brandlogo),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxSize()
                    .scale(1.225f)
            )

        }
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
        Button(
            onClick = { navController.navigate(route = AuthScreen.Signup.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(horizontal = 8.dp)
        ) {
            Text(text = "Let's get started", fontSize = 22.sp, fontFamily = Montserrat, fontWeight = FontWeight.Normal)
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "I already have an account")

            Spacer(modifier = Modifier.padding(4.dp))

            FilledIconButton(
                onClick = { navController.navigate(route = AuthScreen.Login.route) },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Forward arrow",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}