package com.example.grupo22_kotlin.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.grupo22_kotlin.presentation.screens.profile_edit.ProfileEditScreen

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {

    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.ProfileUpdate.route
    ) {



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




        }
    }



sealed class DetailsScreen(val route: String) {


    object ProfileUpdate: DetailsScreen("profile/update/{user}") {
        fun passUser(user: String) = "profile/update/$user"
    }

}