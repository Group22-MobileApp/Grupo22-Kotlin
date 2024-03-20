package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false,

    ) {

    Column() {
        OutlinedTextField(
            modifier  = modifier,
            value = value,
            onValueChange = {onValueChange(it)},
            keyboardOptions = KeyboardOptions(keyboardType= keyboardType),
            label = {
                Text(label)
            },
            visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}

@Preview
@Composable
fun DefaultTextFieldPreview() {
    DefaultTextField(
        modifier = Modifier, // Add appropriate modifier if needed
        value = "", // Pass initial value for preview
        onValueChange = {}, // Pass empty lambda for onValueChange for preview
        label = "Email",
        // Pass label text for preview
        keyboardType = KeyboardType.Email, // Pass appropriate keyboardType for preview
        hideText = false // Pass hideText parameter for preview
    )
}