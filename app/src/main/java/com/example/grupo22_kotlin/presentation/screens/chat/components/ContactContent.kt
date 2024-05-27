package com.example.grupo22_kotlin.presentation.screens.chat.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.presentation.screens.posts.components.PostCardWider

@Composable
fun ContactContent(users: List<User>, navController: NavHostController){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .heightIn(max = 2000.dp)
    ) {
        items(
            count = users.size
        ) { i ->
            ContactCard(user = users[i], navController)
        }
    }
}