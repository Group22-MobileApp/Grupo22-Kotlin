package com.example.grupo22_kotlin.presentation.screens.posts.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Post

@Composable
fun PostContentWider(posts: List<Post>, navController: NavHostController){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .heightIn(max = 2000.dp)
    ) {
        items(
            count = posts.size
        ) { i ->
            PostCardWider(post = posts[i], navController)
        }
    }
}