package com.example.grupo22_kotlin.presentation.screens.signup.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.components.Logo
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.screens.signup.SignupViewModel
import com.example.grupo22_kotlin.presentation.ui.theme.Montserrat
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SignupContent(navController: NavHostController) {

    Box(
        modifier = Modifier.paint(
            painter = painterResource(id = R.drawable.ic_bubblessignup),
            contentScale = ContentScale.FillWidth
        )
    )
    Box(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 70.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            SignupHeader(modifier = Modifier)
            SignupBody(modifier = Modifier, navController = navController)
        }

    }


}

@Composable
fun SignupHeader(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Logo(modifier = Modifier, width = 115.dp, height = 115.dp)
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Create\nAccount",
            textAlign = TextAlign.Start,
            color = darkBlue,
            fontSize = 50.sp,
            fontFamily = Raleway,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp,
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
fun SignupBody(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: SignupViewModel = hiltViewModel(),
    careers: Careers = Careers()
) {



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
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = "Email",
            errorMsg = viewModel.emailErrMsg.value,
            validateField = { viewModel.validateEmail() },
            keyboardType = KeyboardType.Email
        )
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            label = "Password",
            errorMsg = viewModel.passwordErrMsg.value,
            validateField = { viewModel.validatePassword() },
            hideText = true
        )
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.confirmPassword.value,
            onValueChange = { viewModel.confirmPassword.value = it },
            label = "Confirm Password",
            errorMsg = viewModel.confirmPasswordErrMsg.value,
            validateField = { viewModel.validateConfirmPasword() },
            hideText = true
        )
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.number.value,
            onValueChange = {
                if (it.length <= 10 && it.all { char -> char.isDigit() }) viewModel.number.value =
                    it
            },
            label = "Phone number",
            errorMsg = viewModel.numberErrMsg.value,
            validateField = { viewModel.validateNumber() },
            keyboardType = KeyboardType.Number
        )

        var expanded by remember { mutableStateOf(false) }
        Column() {
            DefaultTextField(
                modifier = Modifier
                    .clickable { expanded = true },
                value = viewModel.career.value,
                onValueChange = { viewModel.career.value = it },
                enabled = false,
                readOnly = false,
                label = "Whats your career",
                errorMsg = viewModel.careerErrMsg.value,
                validateField = { viewModel.validateCareer() },
                icon = {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Forward arrow",
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredSizeIn(maxHeight = 350.dp)
            ) {
                careers.careers.forEach { c ->
                    DropdownMenuItem(text = { Text(text = c, fontFamily = Montserrat) }, onClick = {
                        expanded = false
                        viewModel.career.value = c
                        viewModel.validateCareer()
                    })
                }
            }
        }
        Spacer(modifier = Modifier.size(5.dp))
        ImportantButton(
            modifier = Modifier,
            text = "Done",
            onClick = { viewModel.onSignup() },
            enabled = viewModel.isEnabledLoginButton
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Cancel",
            modifier = Modifier.clickable {
                navController.navigate(route = AuthScreen.Start.route)
            }
        )
        Spacer(modifier = Modifier.size(40.dp))


    }


}
