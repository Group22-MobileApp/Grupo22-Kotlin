package com.example.grupo22_kotlin.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.grupo22_kotlin.presentation.screens.myPosts.MyPostsScreen
import com.example.grupo22_kotlin.presentation.screens.postDetail.PostDetailScreen
import com.example.grupo22_kotlin.presentation.screens.postsFetch.PostsFetchScreen
import com.example.grupo22_kotlin.presentation.screens.profile_edit.ProfileEditScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {

    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.ProfileUpdate.route
    ) {

        composable(route = DetailsScreen.MyPosts.route) {
            MyPostsScreen(navController = navController)
        }


        composable(
            route = DetailsScreen.ProfileUpdate.route,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileEditScreen(navController, user = it)
            }
        }

        composable(
            route = DetailsScreen.PostDetail.route,
            arguments = listOf(navArgument("post"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("post")?.let {
                PostDetailScreen(navController, post = it)
            }
        }

        composable(
            route = DetailsScreen.PostType.route,
            arguments = listOf(navArgument("postType"){
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("postType")?.let {
                PostsFetchScreen(postType = it, navController)
            }
        }

        }
    }



sealed class DetailsScreen(val route: String) {

    object MyPosts: DetailsScreen("profile/myPosts")


    object ProfileUpdate: DetailsScreen("profile/update/{user}") {
        fun passUser(user: String) = "profile/update/$user"
    }

    object PostDetail: DetailsScreen("home/detail/{post}") {
        fun passPost(post: String) = "home/detail/$post"
    }

    object PostType: DetailsScreen("home/type/{postType}") {
        fun passPostType(postType: String) = "home/type/$postType"
    }

}