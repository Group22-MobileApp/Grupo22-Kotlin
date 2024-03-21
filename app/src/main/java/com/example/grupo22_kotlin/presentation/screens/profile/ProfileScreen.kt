package com.example.grupo22_kotlin.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.components.DefaultButton
import com.example.grupo22_kotlin.presentation.navigation.AppScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel= hiltViewModel()){
    Scaffold (
        topBar={},
        content={
            Column {
                Text(text = "Profile Screen")
                DefaultButton(modifier = Modifier,
                    text = "Log Out",
                    onClick = {
                        viewModel.logout()
                        navController.navigate(route= AppScreen.Start.route){
                            popUpTo(AppScreen.Profile.route){inclusive=true}
                        }
                    })
            }
            
        }
        )
}