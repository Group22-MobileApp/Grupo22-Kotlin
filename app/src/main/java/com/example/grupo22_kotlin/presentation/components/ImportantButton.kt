package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grupo22_kotlin.presentation.ui.theme.Montserrat
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue


@Composable
fun ImportantButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Button(
        onClick = { onClick() },
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .padding(horizontal = 8.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = darkBlue,
            disabledContainerColor = Color(0xFFF7E394)
        )
    ) {
        Text(
            text = text,
            fontSize = 22.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Normal
        )
    }


}