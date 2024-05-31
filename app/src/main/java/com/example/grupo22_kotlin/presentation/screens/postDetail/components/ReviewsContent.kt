package com.example.grupo22_kotlin.presentation.screens.postDetail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReviewsContent(reviews: List<String>){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .heightIn(max = 2000.dp)
    ) {
        items(
            count = reviews.size
        ) { i ->

            Text(text =reviews[i] )
        }
    }
}