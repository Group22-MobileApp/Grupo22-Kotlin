package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue

@Composable
fun TitleText(text:String, color: Color = darkBlue, fontSize: TextUnit = 35.sp){
    Text(
        text = text,
        textAlign = TextAlign.Start,
        color = color,
        fontSize = fontSize,
        fontFamily = Raleway,
        fontWeight = FontWeight.Bold,
        lineHeight = fontSize
    )
}