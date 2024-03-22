package com.example.grupo22_kotlin.presentation.screens.addPost.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.components.Logo
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.screens.signup.SignupViewModel
import com.example.grupo22_kotlin.presentation.screens.signup.components.Careers
import com.example.grupo22_kotlin.presentation.screens.signup.components.SignupBody
import com.example.grupo22_kotlin.presentation.screens.signup.components.SignupHeader
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue

@Composable
fun AddPostContent(navController: NavHostController, viewModel: SignupViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 20.dp), contentAlignment = Alignment.Center
    ) {
        Column {
            AddPostHeader(modifier = Modifier)
            AddPostBody(modifier = Modifier, navController = navController)
        }

    }
}

@Composable
fun AddPostHeader(modifier: Modifier){
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Create a post",
            textAlign = TextAlign.Start,
            color = darkBlue,
            fontSize = 35.sp,
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold,
            lineHeight = 35.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(20.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
            Image(
                modifier = Modifier.size(95.dp),
                painter = painterResource(id = R.drawable.ic_addphoto),
                contentDescription = "Add a photo"
            )
        }
        Spacer(modifier = Modifier.size(20.dp))

    }
}

@Composable
fun AddPostBody(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: SignupViewModel = hiltViewModel(),
    categories: Categories = Categories()
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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

        var expanded by remember { mutableStateOf(false) }
        DefaultTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            value = viewModel.career.value,
            onValueChange = { viewModel.career.value = it },
            enabled = false,
            readOnly = false,
            label = "Post category",
            errorMsg = viewModel.careerErrMsg.value,
            validateField = { viewModel.validateCareer() }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            categories.categories.forEach { c ->
                DropdownMenuItem(text = { Text(text = c) }, onClick = {
                    expanded = false
                    viewModel.career.value = c
                    viewModel.validateCareer()
                })
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