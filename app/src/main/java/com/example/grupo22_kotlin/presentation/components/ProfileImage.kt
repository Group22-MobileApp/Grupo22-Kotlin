package com.example.grupo22_kotlin.presentation.components

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.ui.theme.amber

@Composable
fun ProfileImage(
    modifier: Modifier,
    profileImageWidth: Dp,
    profileImageHeight: Dp,
    profileImage: String = "",
    isIconButtonVisible: Boolean = false,
    icon: ImageVector,
    onIconButtonClick: () -> Unit = {}
) {
    Box(modifier = modifier.size(profileImageWidth + 10.dp)) {
        Card(
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = modifier
                .width(profileImageWidth)
                .height(profileImageHeight)
                .align(Alignment.Center)
        ) {

            if (profileImage != "") {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    model = profileImage,
                    contentDescription = "User image"
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

        }

        FilledIconButton(
            onClick = { onIconButtonClick() },
            modifier = modifier
                .size(32.dp)
                .alpha(if (isIconButtonVisible) 1f else 0f)
                .align(Alignment.TopEnd),
            colors = IconButtonDefaults.filledIconButtonColors(containerColor = amber),
            enabled = isIconButtonVisible
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Forward arrow",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}