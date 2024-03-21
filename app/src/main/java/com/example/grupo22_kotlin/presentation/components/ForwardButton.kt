package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ForwardButton(
    modifier: Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    FilledIconButton(
        onClick = { onClick() },
        modifier = modifier.size(32.dp),
        enabled = enabled
    ) {
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Forward arrow",
            modifier = Modifier.size(20.dp)
        )
    }
}