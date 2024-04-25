package com.example.grupo22_kotlin.presentation.screens.mainHome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.components.ForwardButton
import com.example.grupo22_kotlin.presentation.navigation.DetailsScreen
import com.example.grupo22_kotlin.presentation.screens.mainHome.ConnectivityObserver
import com.example.grupo22_kotlin.presentation.screens.mainHome.MainHomeViewModel
import com.example.grupo22_kotlin.presentation.screens.posts.components.GetPosts
import com.example.grupo22_kotlin.presentation.screens.posts.components.GetPostsByTaste
import com.example.grupo22_kotlin.presentation.screens.posts.components.GetPostsCategory
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.ProfileImage
import com.example.grupo22_kotlin.presentation.components.TitleText
import com.example.grupo22_kotlin.presentation.screens.profile.ProfileViewModel
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.amber
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue


@Composable
fun MainHomeContent(
    navController: NavHostController,
    viewModel: MainHomeViewModel = hiltViewModel(),
    //connectivityObserver: ConnectivityObserver
) {

    val status by viewModel.connectivityObserver.observe().collectAsState(
        initial = ConnectivityObserver.Status.Unavailable
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (status.toString() == "Unavailable") {
                Row {
                    Text(
                        modifier = Modifier.padding(15.dp),
                        text = "Your actual state is $status",
                        color = Color.Red
                    )
                }
            }

            MainHomeHeader(
                modifier = Modifier,
                navController = navController,
                viewModel = viewModel
            )

            ForYou(modifier = Modifier, navController = navController)

            Categories(modifier = Modifier, navController = navController)

            New(modifier = Modifier, navController = navController)
        }
    }
}


@Composable
fun MainHomeHeader(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: MainHomeViewModel,
    userViewModel: ProfileViewModel = hiltViewModel()
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProfileImage(
                modifier = modifier,
                profileImageWidth = 52.dp,
                profileImageHeight = 52.dp,
                profileImage = userViewModel.userData.image,
                icon = Icons.Default.FavoriteBorder
            )
            Spacer(modifier = modifier.size(16.dp))

            OutlinedTextField(
                modifier = modifier.fillMaxWidth(),
                value = "",
                onValueChange = {

                },
                label = {
                    Text("Search", fontSize = 14.sp)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    unfocusedLabelColor = Color.Gray,
                    focusedBorderColor = darkBlue,
                    focusedLabelColor = darkBlue,
                    cursorColor = darkBlue,
                    unfocusedContainerColor = Color(0xFFF5F5F5)
                ),
                shape = RoundedCornerShape(28.dp)
            )

        }
        Spacer(modifier = modifier.size(16.dp))
        TitleText(text = "Welcome back!", fontSize = 30.sp)
    }

}

@Composable
fun ForYou(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            TitleText(text = "Just for you", color = Color.Black, fontSize = 22.sp)
            Spacer(modifier = modifier.size(4.dp))
            Icon(imageVector = Icons.Default.Star, tint = amber, contentDescription = "Star")
            Spacer(modifier = modifier.weight(1f))
            Text(text = "See all", fontWeight = FontWeight.Medium, fontFamily = Raleway)
            Spacer(modifier = modifier.size(8.dp))
            ForwardButton(
                modifier = modifier,
                color = amber,
                iconTint = Color.White,
                onClick = { navController.navigate(route = DetailsScreen.PostType.passPostType("forYou")) })

        }
        GetPostsByTaste(navController)
    }
}

@Composable
fun Categories(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            TitleText(text = "Categories", color = Color.Black, fontSize = 22.sp)
            Spacer(modifier = modifier.weight(1f))
            Text(text = "See all", fontWeight = FontWeight.Medium, fontFamily = Raleway)
            Spacer(modifier = modifier.size(8.dp))
            ForwardButton(
                modifier = modifier,
                color = amber,
                iconTint = Color.White,
                onClick = { navController.navigate(route = DetailsScreen.PostType.passPostType("categories")) })

        }
        GetPostsCategory(navController)
    }
}

@Composable
fun New(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            TitleText(text = "New Items", color = Color.Black, fontSize = 22.sp)
            Spacer(modifier = modifier.size(4.dp))
            Image(painter = painterResource(id = R.drawable.ic_fire), contentDescription = "fire")
            Spacer(modifier = modifier.weight(1f))
            Text(text = "See all", fontWeight = FontWeight.Medium, fontFamily = Raleway)
            Spacer(modifier = modifier.size(8.dp))
            ForwardButton(
                modifier = modifier,
                color = amber,
                iconTint = Color.White,
                onClick = { navController.navigate(route = DetailsScreen.PostType.passPostType("posts")) })

        }
        GetPosts(navController)
    }
}

@Composable
fun NoConnectivity() {
    Column {
        Text(text = "No connectivity")
    }
}