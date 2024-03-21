package com.example.grupo22_kotlin.presentation.screens.addPost.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.screens.signup.SignupViewModel
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue

@Composable
fun AddPostContent(navController: NavHostController, viewModel: SignupViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Create a post".uppercase(),
            color = darkBlue,
            fontSize = 25.sp,
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.username.value,
            onValueChange = { viewModel.username.value = it },
            label = "Name",
            errorMsg = viewModel.usernameErrMsg.value,
            validateField = { viewModel.validateUsername() }
        )
        Spacer(modifier = Modifier.height(8.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = "Price",
            errorMsg = viewModel.emailErrMsg.value,
            validateField = { viewModel.validateEmail() },
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(8.dp))
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            label = "Description",
            errorMsg = viewModel.passwordErrMsg.value,
            validateField = { viewModel.validatePassword() },
            hideText = true
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Condition",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    fontFamily = Raleway,
                )
                CustomCheckbox("New")
                CustomCheckbox("Used")

            }
            Column {
                Text(
                    text = "Interchangeable",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    fontFamily = Raleway,
                )
                CustomCheckbox("Yes")
                CustomCheckbox("No")
            }
        }

        ImportantButton(
            modifier = Modifier,
            text = "POST",
            onClick = { navController.navigate(route = AuthScreen.Login.route) },
            enabled = viewModel.isEnabledLoginButton
        )


    }
}

@Composable
fun CustomCheckbox(text: String) {
    val checked = remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text
        )
        Checkbox(
            checked = checked.value,
            onCheckedChange = { isChecked -> checked.value = isChecked },
        )
    }
}