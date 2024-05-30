package com.example.grupo22_kotlin.presentation.screens.favorites

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
import com.example.grupo22_kotlin.presentation.screens.favorites.components.GetPostsLiked

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FavoritesScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
        },
        content = {
            Column(modifier = Modifier.padding(top=55.dp)) {
                GetPostsLiked(navController = navController)
            }
        },
        bottomBar = {}

    )

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewMainHomeScreen(){
    FavoritesScreen(rememberNavController())
}