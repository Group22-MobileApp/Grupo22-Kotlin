package com.example.grupo22_kotlin.presentation.screens.profileDetail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.components.ProfileImage
import com.example.grupo22_kotlin.presentation.components.TitleText
import com.example.grupo22_kotlin.presentation.screens.profileDetail.ProfileDetailViewModel
import com.example.grupo22_kotlin.presentation.ui.theme.amber

@Composable
fun ProfileDetailContent(
    navController: NavHostController,
    viewModel: ProfileDetailViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 55.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            ProfileDetailHeader(
                modifier = Modifier,
                navController = navController,
                viewModel = viewModel
            )
        }

    }
}

@Composable
fun ProfileDetailHeader(
    modifier: Modifier, navController: NavHostController, viewModel: ProfileDetailViewModel
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TitleText(text = "Profile")
        Spacer(modifier = Modifier.size(16.dp))
        Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            ProfileImage(
                modifier = Modifier,
                profileImageWidth = 100.dp,
                profileImageHeight = 100.dp,
                icon = Icons.Outlined.Add,
                profileImage = viewModel.user.image
            )
            Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "4.6", fontSize = 48.sp)
                Row {
                    Icon(imageVector = Icons.Filled.Star, tint = amber, contentDescription = "")
                    Icon(imageVector = Icons.Filled.Star, tint = amber, contentDescription = "")
                    Icon(imageVector = Icons.Filled.Star, tint = amber, contentDescription = "")
                    Icon(imageVector = Icons.Filled.Star, tint = amber, contentDescription = "")
                    Icon(imageVector = Icons.Outlined.Star, tint = amber, contentDescription = "")
                }
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Username:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Card(
            modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFAFA))
        ) {
            Text(modifier = modifier.padding(8.dp), text = viewModel.user.username)
        }
        Text(text = "E-mail:", fontSize = 12.sp, fontWeight = FontWeight.Bold)

        Card(
            modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFAFA))
        ) {
            Text(modifier = modifier.padding(8.dp), text = viewModel.user.email)
        }
        Text(text = "Career:", fontSize = 12.sp, fontWeight = FontWeight.Bold)

        Card(
            modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            shape = RoundedCornerShape(5.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFAFA))
        ) {
            Text(modifier = modifier.padding(8.dp), text = viewModel.user.career)
        }
    }
}