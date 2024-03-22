package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.grupo22_kotlin.R

@Composable
fun Logo(
    modifier: Modifier,
    width: Dp,
    height: Dp
){
    Card(
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
            .width(width)
            .height(height)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_brandlogo),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxSize()
                .scale(1.225f)
        )

    }
}