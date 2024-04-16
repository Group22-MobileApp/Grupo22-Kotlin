package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grupo22_kotlin.R

@Composable
fun InformationCard(info: String = "", iconVisible: Boolean = false) {

    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE9E9E9)),
        shape = RoundedCornerShape(6.dp)
    ) {
        Row {
            Spacer(modifier = Modifier.width(14.dp))
            if (iconVisible) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_interchangeable),
                    contentDescription = "Interchangeable icon",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 4.dp)
                )
            }
            Text(
                text = info,
                modifier = Modifier.padding(start = 0.dp, end = 14.dp, top = 4.dp, bottom = 4.dp),
                fontSize = 14.sp
            )
        }
    }
}