package com.example.grupo22_kotlin.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.MainActivity
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.components.ProfileImage
import com.example.grupo22_kotlin.presentation.components.TitleText
import com.example.grupo22_kotlin.presentation.navigation.DetailsScreen
import com.example.grupo22_kotlin.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(
    navController: NavHostController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 70.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            MenuProfileHeader(
                modifier = Modifier,
                navController = navController,
                viewModel = viewModel
            )
            MenuProfileBody(
                modifier = Modifier,
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun MenuProfileHeader(
    modifier: Modifier, navController: NavHostController, viewModel: ProfileViewModel
) {
    Column(modifier = modifier.fillMaxWidth()) {
        TitleText(text = "Profile")
        Spacer(modifier = modifier.size(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            ProfileImage(
                modifier = Modifier,
                profileImageWidth = 100.dp,
                profileImageHeight = 100.dp,
                isIconButtonVisible = true,
                onIconButtonClick = {
                    navController.navigate(
                        route = DetailsScreen.ProfileUpdate.passUser(viewModel.userData.toJson())
                    )
                }
            )
            Spacer(modifier = modifier.size(16.dp))
            TitleText(
                text = "Hello, " + viewModel.userData.username + "!",
                color = Color.Black,
                fontSize = 28.sp
            )
        }
    }
}

@Composable
fun MenuProfileBody(
    modifier: Modifier, navController: NavHostController, viewModel: ProfileViewModel
) {
    val activity = LocalContext.current as? Activity
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(70.dp)
                .clickable { }
        ) {
            Text(
                text = "Profile",
                fontWeight = FontWeight.SemiBold,
                modifier = modifier.align(Alignment.CenterStart)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next",
                modifier
                    .align(Alignment.CenterEnd)
                    .size(30.dp)
            )
            Spacer(
                modifier = modifier
                    .height(1.dp)
                    .background(Color.LightGray)
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
            )
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(70.dp)
                .clickable { }
        ) {
            Text(
                text = "History",
                fontWeight = FontWeight.SemiBold,
                modifier = modifier.align(Alignment.CenterStart)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next",
                modifier
                    .align(Alignment.CenterEnd)
                    .size(30.dp)
            )
            Spacer(
                modifier = modifier
                    .height(1.dp)
                    .background(Color.LightGray)
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
            )
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(70.dp)
                .clickable { }
        ) {
            Text(
                text = "Crate a post",
                fontWeight = FontWeight.SemiBold,
                modifier = modifier.align(Alignment.CenterStart)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next",
                modifier
                    .align(Alignment.CenterEnd)
                    .size(30.dp)
            )
            Spacer(
                modifier = modifier
                    .height(1.dp)
                    .background(Color.LightGray)
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
            )
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(70.dp)
                .clickable { }
        ) {
            Text(
                text = "My reviews",
                fontWeight = FontWeight.SemiBold,
                modifier = modifier.align(Alignment.CenterStart)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next",
                modifier
                    .align(Alignment.CenterEnd)
                    .size(30.dp)
            )
            Spacer(
                modifier = modifier
                    .height(1.dp)
                    .background(Color.LightGray)
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = modifier.size(32.dp))
        ImportantButton(modifier = Modifier,
            text = "Log Out",
            onClick = {
                viewModel.logout()
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            }
        )

    }
}
