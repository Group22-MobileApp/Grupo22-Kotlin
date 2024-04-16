package com.example.grupo22_kotlin.presentation.screens.postDetail.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.presentation.screens.postDetail.PostDetailViewModel

@Composable
fun PostDetailContent(navController: NavHostController, viewModel: PostDetailViewModel = hiltViewModel()){

    Text(text = viewModel.post.name)

}