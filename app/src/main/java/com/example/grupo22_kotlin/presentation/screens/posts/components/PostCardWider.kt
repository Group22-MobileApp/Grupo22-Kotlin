package com.example.grupo22_kotlin.presentation.screens.posts.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.presentation.components.FavButton
import com.example.grupo22_kotlin.presentation.components.InformationCard
import com.example.grupo22_kotlin.presentation.navigation.DetailsScreen

@Composable
fun PostCardWider(post: Post, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp)
            .height(150.dp)
            .clickable {
                navController.navigate(route = DetailsScreen.PostDetail.passPost(post.toJson()))
            },
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row() {
            AsyncImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp)),
                model = post.image,
                contentDescription = "",
                contentScale = ContentScale.FillHeight
            )
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .weight(1.5f),
                    text = post.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .weight(1f),
                    text = "$ " + post.price,
                    fontWeight = FontWeight.Normal,
                    fontSize = 22.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InformationCard(info = post.condition)
                    if (post.interchangeable.lowercase() == "yes") {
                        Spacer(modifier = Modifier.size(8.dp))
                        InformationCard(info = "", iconVisible = true)
                    }
                }
            }
        }
    }
}