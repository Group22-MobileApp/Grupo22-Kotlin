package com.example.grupo22_kotlin.presentation.screens.chat

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.grupo22_kotlin.presentation.screens.chat.components.ChatContent
import com.example.grupo22_kotlin.presentation.screens.mainHome.components.MainHomeContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChatScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
        },
        content = {
            Column(modifier = Modifier.padding(top=55.dp)) {
                ChatContent(navController = navController)
            }
        },
        bottomBar = {}

    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainHomeScreen(){
    ChatScreen(rememberNavController())
}