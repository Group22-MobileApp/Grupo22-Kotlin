package com.example.grupo22_kotlin.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue
import com.example.grupo22_kotlin.presentation.ui.theme.yellow
import kotlin.math.sin

@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    validateField: () -> Unit = {},
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false,
    errorMsg: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    icon: @Composable () -> Unit = {},
    singleLine: Boolean = true
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = {
            onValueChange(it)
            validateField()
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        label = {
            Text(label, fontSize = 14.sp)
        },
        singleLine = singleLine,
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
            unfocusedLabelColor = Color.Gray,
            focusedBorderColor = darkBlue,
            focusedLabelColor = darkBlue,
            cursorColor = darkBlue,
            unfocusedContainerColor = Color(0xFFF5F5F5)
        ),
        enabled = enabled,
        readOnly = readOnly,
        trailingIcon = {icon()}
    )
    Text(
        modifier = Modifier.padding(top = 5.dp),
        fontSize = 11.sp,
        fontWeight = FontWeight.SemiBold,
        text = errorMsg,
        color = Color.Red
    )

}

