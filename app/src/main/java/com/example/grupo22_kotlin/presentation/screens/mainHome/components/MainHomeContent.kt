package com.example.grupo22_kotlin.presentation.screens.mainHome.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.ForwardButton
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.navigation.DetailsScreen
import com.example.grupo22_kotlin.presentation.screens.mainHome.ConnectivityObserver
import com.example.grupo22_kotlin.presentation.screens.mainHome.MainHomeViewModel
import com.example.grupo22_kotlin.presentation.screens.mainHome.NetworkConnectivityObserver
import com.example.grupo22_kotlin.presentation.screens.posts.components.GetPosts
import com.example.grupo22_kotlin.presentation.screens.posts.components.GetPostsByTaste
import com.example.grupo22_kotlin.presentation.screens.posts.components.GetPostsCategory
import com.example.grupo22_kotlin.presentation.screens.signup.SignupViewModel
import com.google.android.gms.common.api.internal.LifecycleActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleOwner


@Composable
fun MainHomeContent(
    navController: NavHostController,
    viewModel: MainHomeViewModel = hiltViewModel(),

) {

    var isOnline by remember { mutableStateOf(false) }

    val lifecycleOwner = LocalLifecycleOwner.current

    viewModel.isOnline.observe(lifecycleOwner) { newIsOnline ->
        isOnline = newIsOnline
    }

    if (!isOnline){
        NoConnectivity()
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Main Home Page"
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Main Posts")

            Spacer(modifier = Modifier.padding(4.dp))

            ForwardButton(
                modifier = Modifier,
                onClick = {
                    navController.navigate(route = DetailsScreen.PostType.passPostType("posts"))
                })
        }

        GetPosts(navController)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "For you")

            Spacer(modifier = Modifier.padding(4.dp))

            ForwardButton(
                modifier = Modifier,
                onClick = {
                    navController.navigate(route = DetailsScreen.PostType.passPostType("forYou"))
                })
        }

        GetPostsByTaste(navController)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Categories")

            Spacer(modifier = Modifier.padding(4.dp))

            ForwardButton(
                modifier = Modifier,
                onClick = {
                    navController.navigate(route = DetailsScreen.PostType.passPostType("categories"))
                })
        }

        GetPostsCategory(navController)

    }
}

@Composable
fun NoConnectivity(){
    Column {
        Text(text = "No connectivity")
    }
}