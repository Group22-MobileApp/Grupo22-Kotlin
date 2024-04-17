package com.example.grupo22_kotlin.presentation.screens.postsFetch.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.presentation.screens.myPosts.components.MyPostsCard

@Composable
fun PostFetchContent(
    postType:String,
    viewModel: ViewModel,
    navController: NavHostController
) {
    if (postType == "posts"){
        GetAllPosts(navController)
    }
}