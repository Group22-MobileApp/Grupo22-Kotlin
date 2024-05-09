package com.example.grupo22_kotlin.presentation.screens.chat.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.screens.chat.ChatViewModel
import com.example.grupo22_kotlin.presentation.screens.posts.components.PostCardWider
import com.example.grupo22_kotlin.presentation.screens.posts.components.PostContentWider
import com.example.grupo22_kotlin.presentation.screens.postsFetch.PostsFetchViewModel

@Composable
fun GetContacts(contacts: ArrayList<String>, navController: NavHostController){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .heightIn(max = 2000.dp)
    ) {
        items(
            count = contacts.size
        ) { i ->
            ContactCard(contact = contacts[i], navController)
        }
    }
}