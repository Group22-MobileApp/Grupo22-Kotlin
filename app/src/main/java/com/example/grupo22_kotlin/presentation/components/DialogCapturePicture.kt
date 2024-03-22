package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun DialogCapturePicture(
    status: MutableState<Boolean>,
    takePhoto: () -> Unit,
    pickImage: () -> Unit,
) {

    if (status.value) {
        AlertDialog(
            onDismissRequest = { status.value = false },
            confirmButton = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(onClick = {
                        status.value = false
                        pickImage()
                    }) {
                        Text(text = "Album")
                    }
                    Button(onClick = {
                        status.value = false
                        takePhoto()
                    }) {
                        Text(text = "Camera")
                    }
                }
            },
            title = {
                TitleText(text = "Select an option", color = Color.Black, fontSize = 24.sp)
            },

            )
    }

}