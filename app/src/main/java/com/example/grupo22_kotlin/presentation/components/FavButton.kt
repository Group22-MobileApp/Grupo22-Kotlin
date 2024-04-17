package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue

@Composable
fun FavButton(modifier: Modifier) {
    var isFav by remember { mutableStateOf(false) }
    Surface(
        modifier = modifier,
        shape = CircleShape,
        shadowElevation = 6.dp
    ) {
        OutlinedIconButton(
            onClick = { isFav = !isFav },
            border = BorderStroke(0.dp, Color.White),
            modifier = modifier.size(52.dp)
        ) {
            if (!isFav) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite icon",
                    modifier = modifier.size(32.dp),
                    tint = darkBlue
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite icon",
                    modifier = modifier.size(32.dp),
                    tint = darkBlue
                )
            }
        }
    }
}