package com.example.grupo22_kotlin.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grupo22_kotlin.presentation.screens.addPost.AddPostScreen
import com.example.grupo22_kotlin.presentation.screens.chat.ChatScreen
import com.example.grupo22_kotlin.presentation.screens.favorites.FavoritesScreen
import com.example.grupo22_kotlin.presentation.screens.mainHome.MainHomeScreen
import com.example.grupo22_kotlin.presentation.screens.profile.ProfileScreen


@Composable
fun BottomBarNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {

        composable(route = BottomBarScreen.Home.route) {
            MainHomeScreen(navController)
        }

        composable(route = BottomBarScreen.Favorites.route) {
            FavoritesScreen(navController)
        }

        composable(route = BottomBarScreen.AddPosts.route) {
            AddPostScreen(navController)
        }

        composable(route = BottomBarScreen.Chat.route) {
            ChatScreen(navController)
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
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Favorites: BottomBarScreen(
        route = "favorites",
        title = "Favorites",
        icon = Icons.Default.Favorite
    )

    object AddPosts: BottomBarScreen(
        route = "post",
        title = "Posts",
        icon = Icons.Outlined.Add
    )

    object Chat: BottomBarScreen(
        route = "chat",
        title = "Chat",
        icon = Icons.Outlined.MailOutline
    )

    object Profile: BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

}