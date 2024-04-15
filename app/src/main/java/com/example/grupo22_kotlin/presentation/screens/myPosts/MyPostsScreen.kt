package com.example.grupo22_kotlin.presentation.screens.myPosts

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.components.TitleText
import com.example.grupo22_kotlin.presentation.navigation.DetailsScreen
import com.example.grupo22_kotlin.presentation.screens.myPosts.components.GetPostsByUserId
import com.example.grupo22_kotlin.presentation.screens.posts.PostViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyPostsScreen(navController: NavHostController, viewModel: PostViewModel = hiltViewModel()) {

    Scaffold(
        content = {
            GetPostsByUserId(navController = navController)
        }
    )

}

@Composable
fun MyPostHeader(modifier: Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        TitleText(text = "My Posts")
    }
}
//TODO tengo dudas de donde debería quedar MyPostsHeader