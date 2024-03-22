package com.example.grupo22_kotlin.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.MainActivity
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.navigation.DetailsScreen
import com.example.grupo22_kotlin.presentation.screens.profile.ProfileViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun ProfileContent(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as? Activity
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Profile")
        Spacer(modifier = Modifier.height(30.dp))
        if(viewModel.userData.image != ""){
            AsyncImage(
                modifier = Modifier.size(115.dp).clip(CircleShape),
                model = viewModel.userData.image,
                contentDescription = "User image")
        }else{
            Image(
                painter = painterResource(id = R.drawable.ic_brandlogo),
                contentDescription = "User_Login"
            )

        }

        Spacer(modifier = Modifier.height(30.dp))
        Text(text = viewModel.userData.username, fontSize = 25.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = viewModel.userData.email, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(30.dp))
        ImportantButton(
            modifier = Modifier,
            text = "Editar Datos",
            onClick = {
               navController.navigate(
                    route = DetailsScreen.ProfileUpdate.passUser(viewModel.userData.toJson())
                )
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        ImportantButton(modifier = Modifier,
            text = "Log Out",
            onClick = {
                viewModel.logout()
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            })

    }
}