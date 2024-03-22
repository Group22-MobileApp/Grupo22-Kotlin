package com.example.grupo22_kotlin.presentation.screens.profile_edit.components


import android.annotation.SuppressLint
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
import androidx.compose.material.icons.outlined.Add
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.components.DialogCapturePicture
import com.example.grupo22_kotlin.presentation.components.ProfileImage
import com.example.grupo22_kotlin.presentation.components.TitleText
import com.example.grupo22_kotlin.presentation.screens.profile_edit.ProfileEditViewModel
import com.example.grupo22_kotlin.presentation.screens.signup.components.Careers

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ProfileEditContent(
    navController: NavHostController,
    viewModel: ProfileEditViewModel = hiltViewModel(),
) {


    Box(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 55.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            EditProfileHeader(
                modifier = Modifier,
                navController = navController,
                viewModel = viewModel
            )
            EditProfileBody(modifier = Modifier, navController = navController)
        }

    }


}

@Composable
fun EditProfileHeader(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: ProfileEditViewModel
) {
    viewModel.resultingActivitiHandler.handle()
    var dialogState = remember { mutableStateOf(false) }
    DialogCapturePicture(status = dialogState,
        takePhoto = { viewModel.takePhoto() },
        pickImage = { viewModel.pickImage() })
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TitleText(text = "Edit profile")
        Spacer(modifier = Modifier.size(16.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
            ProfileImage(
                modifier = Modifier,
                profileImageWidth = 100.dp,
                profileImageHeight = 100.dp,
                isIconButtonVisible = true,
                icon = Icons.Outlined.Add,
                profileImage = viewModel.image.value,
                onIconButtonClick = {
                    dialogState.value = true
                }
            )

        }
        Spacer(modifier = Modifier.size(20.dp))

    }
}


@Composable
fun EditProfileBody(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: ProfileEditViewModel = hiltViewModel(),
    careers: Careers = Careers()
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()).padding(vertical = 8.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = viewModel.username.value,
            onValueChange = { viewModel.username.value = it },
            label = "Name",
            errorMsg = viewModel.usernameErrMsg.value,
            validateField = { viewModel.validateUsername() }
        )


        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
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
                    .fillMaxWidth()
                    .clickable { expanded = true },
                value = viewModel.career.value,
                onValueChange = { viewModel.career.value = it },
                enabled = false,
                readOnly = false,
                label = "Whats your career",
                errorMsg = viewModel.careerErrMsg.value,
                validateField = {
                    viewModel.validateCareer()
                },
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
                    DropdownMenuItem(text = { Text(text = c) }, onClick = {
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
            text = "Actualizar Datos",
            onClick = {
                viewModel.saveImage()
                navController.popBackStack()
            },
            enabled = viewModel.isEnabledActualizarDatos
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Cancel",
            modifier = Modifier.clickable {
                navController.popBackStack()
            }
        )
        Spacer(modifier = Modifier.size(40.dp))


    }


}