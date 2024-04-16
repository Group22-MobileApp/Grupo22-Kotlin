package com.example.grupo22_kotlin.presentation.screens.posts.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Post

@Composable
fun PostContentForYou(posts: List<Post>, navController: NavHostController){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
            .height(500.dp)
    ) {
        items(
            items = posts
        ) { post ->
            PostCard(post = post, navController)
        }
    }
}