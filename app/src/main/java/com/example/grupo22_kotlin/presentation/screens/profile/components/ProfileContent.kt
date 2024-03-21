package com.example.grupo22_kotlin.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.MainActivity
import com.example.grupo22_kotlin.presentation.components.DefaultButton
import com.example.grupo22_kotlin.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(navController: NavHostController, viewModel:ProfileViewModel = hiltViewModel()){
    val activity = LocalContext.current as? Activity
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Profile")
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_brandlogo) ,
            contentDescription = "User_Login")
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Nombre del usuario")
        Text(text = "Email del usuario")
        DefaultButton(modifier = Modifier,
            text = "Editar Datos",
            onClick = {},
            color = Color.Blue)
        DefaultButton(modifier = Modifier,
            text = "Log Out",
            onClick = {
                viewModel.logout()
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            })

    }
}