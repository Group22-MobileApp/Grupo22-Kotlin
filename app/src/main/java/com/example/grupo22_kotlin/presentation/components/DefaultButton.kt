package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    errorMsg: String="",
    onClick: () -> Unit,
    color: Color = Color.Yellow,
    icon: ImageVector = Icons.Default.ArrowForward,
    enabled: Boolean = true
){
    Column {
        Button(
            modifier = modifier,
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(containerColor = color),

            enabled = enabled
        ) {
            Icon(
                imageVector = icon,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = text, color = Color.Black)
        }

        Text(
            modifier = Modifier.padding(top =5.dp),
            text = errorMsg,
            fontSize = 11.sp,
            color = Color.Red)
    }


}