package com.example.grupo22_kotlin.presentation.screens.mainHome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.screens.posts.components.GetPosts
import com.example.grupo22_kotlin.presentation.screens.posts.components.GetPostsByTaste
import com.example.grupo22_kotlin.presentation.screens.signup.SignupViewModel

@Composable
fun MainHomeContent(
    navController: NavHostController,
    viewModel: SignupViewModel = hiltViewModel(),
) {
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

        Row {
            Column {
                Text(
                    modifier = Modifier.padding(15.dp),
                    text = "Main Posts"
                )
                GetPosts(navController)
            }
        }

        Row {
            Column {
                Text(
                    modifier = Modifier.padding(15.dp),
                    text = "For You"
                )
                GetPostsByTaste(navController)
            }
        }

        Text(
            modifier = Modifier.padding(15.dp),
            text = "Categories"
        )

    }
}