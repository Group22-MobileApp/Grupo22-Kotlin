package com.example.grupo22_kotlin.presentation.screens.addPost

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
import com.example.grupo22_kotlin.presentation.components.DefaultTopBar
import com.example.grupo22_kotlin.presentation.screens.addPost.components.AddPostContent
import com.example.grupo22_kotlin.presentation.screens.addPost.components.NewPost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddPostScreen(navController: NavHostController) {
    Scaffold(
        topBar = {

        },
        content = {
            AddPostContent(navController = navController)
        },
        bottomBar = {}

    )
    NewPost()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAddPostScreen() {
    AddPostScreen(rememberNavController())
}