package com.example.grupo22_kotlin.presentation.screens.myPosts.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.presentation.screens.myPosts.MyPostsViewModel
import com.example.grupo22_kotlin.presentation.screens.posts.components.PostCard

@Composable
fun MyPostsCard (post: Post, viewModel: MyPostsViewModel = hiltViewModel()){
    Card(
        modifier = Modifier
            .padding(top = 0.dp, bottom = 15.dp)
            .clickable {
                //TODO
                // on click navigate to the detail
            },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(width = 1.1.dp, color = Color.LightGray)

    ) {
        Column() {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp),
                model = post.image,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Row {
                Column {
                    Text(
                        modifier = Modifier.padding(horizontal = 15.dp, vertical = 1.dp),
                        text = post.name,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 15.dp, vertical = 1.dp),
                        text = post.price,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column {
                    Button(
                        onClick = { viewModel.delete(post.id) },

                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Delete"
                        )
                    }
                }
            }
        }
    }
}