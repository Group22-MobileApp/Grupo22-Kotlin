package com.example.grupo22_kotlin.presentation.screens.favorites.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.presentation.screens.favorites.FavoritesViewModel
import com.example.grupo22_kotlin.presentation.screens.mainHome.ConnectivityObserver

@Composable
fun FavoritesContent(
    posts: List<Post>,
    viewModel: FavoritesViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val status by viewModel.connectivityObserver.observe().collectAsState(
        initial = ConnectivityObserver.Status.Unavailable
    )

    if (status.toString() == "Unavailable" || status.toString() == "Lost") {
        Image(
            modifier = Modifier.size(64.dp),
            painter = painterResource(id = R.drawable.ic_errorconnection),
            contentDescription = "error internet connection"
        )
        Text(
            text = "No Internet connection",
            color = Color(0xFFBBBBBB),
            fontWeight = FontWeight.SemiBold
        )

    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.height(100.dp),
            painter = painterResource(id = R.drawable.ic_brandlogo),
            contentDescription = "Logo"
        )
        Text(
            modifier = Modifier.padding(15.dp),
            text = "List of Favorites"
        )
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 55.dp)
    ) {
        items(
            items = posts
        ) { post ->
            MyPostsCard(post = post, navController = navController)
        }
    }

}