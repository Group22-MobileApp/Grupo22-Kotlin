package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue
import com.example.grupo22_kotlin.presentation.ui.theme.yellow

@Composable
fun ForwardButton(
    modifier: Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    color: Color = yellow,
    iconTint: Color = darkBlue
) {
    FilledIconButton(
        onClick = { onClick() },
        modifier = modifier.size(32.dp),
        enabled = enabled,
        colors = IconButtonDefaults.iconButtonColors(containerColor = color)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Forward arrow",
            modifier = Modifier.size(20.dp),
            tint = iconTint
        )
    }
}