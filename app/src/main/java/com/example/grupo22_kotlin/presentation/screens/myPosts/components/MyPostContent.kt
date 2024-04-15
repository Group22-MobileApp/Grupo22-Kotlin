package com.example.grupo22_kotlin.presentation.screens.myPosts.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Post

@Composable
fun MyPostsContent(
    posts: List<Post>,
    viewModel: ViewModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(
            items = posts
        ) { post ->
            MyPostsCard(post = post)
        }
    }
}