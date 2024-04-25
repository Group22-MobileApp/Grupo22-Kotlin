package com.example.grupo22_kotlin.presentation.screens.postDetail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.grupo22_kotlin.presentation.components.FavButton
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.components.InformationCard
import com.example.grupo22_kotlin.presentation.components.ProfileImage
import com.example.grupo22_kotlin.presentation.components.TitleText
import com.example.grupo22_kotlin.presentation.screens.postDetail.PostDetailViewModel
import com.example.grupo22_kotlin.presentation.ui.theme.Montserrat
import com.example.grupo22_kotlin.presentation.ui.theme.amber
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue

@Composable
fun PostDetailContent(
    navController: NavHostController,
    viewModel: PostDetailViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        PostDetailHeader(modifier = Modifier, viewModel = viewModel)
        PostDetailBody(modifier = Modifier, navController = navController, viewModel = viewModel)
    }

}

@Composable
fun PostDetailHeader(modifier: Modifier, viewModel: PostDetailViewModel) {
    val configuration = LocalConfiguration.current
    val screenHeightDp = configuration.screenHeightDp.dp
    val imageHeight = screenHeightDp * 0.5f

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(imageHeight)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = viewModel.post.image,
            contentScale = ContentScale.Crop,
            contentDescription = "Post image"
        )
    }
}

@Composable
fun PostDetailBody(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: PostDetailViewModel
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 20.dp),
    ) {

        Column(modifier = modifier.fillMaxWidth()) {
            TitleText(text = viewModel.post.name)
            Spacer(modifier = modifier.size(8.dp))

            Text(text = "$ " + viewModel.post.price, fontSize = 26.sp)
            Spacer(modifier = modifier.size(8.dp))

            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                InformationCard(info = viewModel.post.condition)
                if (viewModel.post.interchangeable.lowercase() == "yes") {
                    Spacer(modifier = modifier.size(8.dp))
                    InformationCard(info = "Interchangeable", iconVisible = true)
                }
                Spacer(Modifier.weight(1f))
                FavButton(modifier = modifier)
            }
            Spacer(modifier = modifier.size(18.dp))

            ImportantButton(modifier = modifier, text = "I want it", onClick = { /*TODO*/ })
            Spacer(modifier = modifier.size(18.dp))

            TitleText(text = "Description", fontSize = 24.sp)
            Spacer(modifier = modifier.size(8.dp))

            Text(text = viewModel.post.description)
            Spacer(modifier = modifier.size(18.dp))

            TitleText(text = "Offered by", fontSize = 24.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                viewModel.post.user?.let {
                    ProfileImage(
                        modifier = modifier,
                        profileImageWidth = 64.dp,
                        profileImageHeight = 64.dp,
                        profileImage = it.image,
                        icon = Icons.Default.FavoriteBorder
                    )
                }
                Spacer(modifier = modifier.size(10.dp))

                val text = viewModel.post.user?.username?.let {
                    if (it.length > 15) it.take(15) + "..."
                    else it
                }
                Column {
                    if (text != null) {
                        Text(text = text, fontSize = 14.sp)
                    }

                    Icon(imageVector = Icons.Default.Star, contentDescription = "Star", tint = amber)
                }
                Spacer(Modifier.weight(1f))

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = darkBlue
                    )
                ) {
                    Text(
                        text = "View profile",
                        fontSize = 12.sp,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

        }
    }
}