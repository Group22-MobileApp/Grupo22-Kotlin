package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState


@Composable
fun DialogCapturePicture(
    status: MutableState<Boolean>,
    takePhoto:() -> Unit,
    pickImage:() -> Unit,
){
    
    if(status.value){
        AlertDialog(
            onDismissRequest = { status.value = false},
            confirmButton = { 
                            Row {
                                Button(onClick = {
                                    status.value = false
                                    pickImage() }) {
                                    Text(text = "Galeria")
                                }
                                Button(onClick = {
                                    status.value = false
                                    takePhoto() }) {
                                    Text(text = "Camara")
                                }
                            }
            },
            title = {
                Text(text = "Selecciona una opcion")
            },
            
        )
    }
    
}