package com.example.grupo22_kotlin.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grupo22_kotlin.presentation.screens.addPost.AddPostScreen
import com.example.grupo22_kotlin.presentation.screens.profile.ProfileScreen


@Composable
fun BottomBarNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {

        composable(route = BottomBarScreen.Home.route) {
            ProfileScreen(navController)
        }

        composable(route = BottomBarScreen.AddPosts.route) {
            AddPostScreen(navController)
        }

        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(navController)
        }

    }

}

sealed class BottomBarScreen(
    val route: String,
    var title: String,
    val icon: ImageVector
) {

    object Home: BottomBarScreen(
        route = "profile",
        title = "Home",
        icon = Icons.Default.Home
    )

    object AddPosts: BottomBarScreen(
        route = "post",
        title = "Posts",
        icon = Icons.Outlined.Add
    )

    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

}