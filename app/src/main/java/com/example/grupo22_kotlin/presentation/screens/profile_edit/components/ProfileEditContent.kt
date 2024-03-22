package com.example.grupo22_kotlin.presentation.screens.profile_edit.components


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.components.Logo
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.navigation.Graph
import com.example.grupo22_kotlin.presentation.screens.profile.ProfileViewModel
import com.example.grupo22_kotlin.presentation.screens.profile_edit.ProfileEditViewModel
import com.example.grupo22_kotlin.presentation.screens.signup.SignupViewModel
import com.example.grupo22_kotlin.presentation.screens.signup.components.Careers
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue
import com.example.grupo22_kotlin.presentation.utils.ComposeFileProvider

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ProfileEditContent(navController: NavHostController,viewModel: ProfileEditViewModel = hiltViewModel(),) {

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {uri->
            uri?.let { viewModel.onResult(it) }

        })

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = {hasImage->
             viewModel.onCameraResult(hasImage)

        })

    val context = LocalContext.current

    Box(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 70.dp), contentAlignment = Alignment.Center
    ) {
        Column {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Editar Perfil",
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
                    if(viewModel.hasImage && viewModel.imageUri != null){
                        AsyncImage(
                            modifier = Modifier.height(100.dp).clip(CircleShape),                            model = viewModel.imageUri,
                            contentDescription = ""
                        )
                    }else{
                        Image(
                            modifier = Modifier
                                .size(95.dp)
                                .clickable {
                                    //imagePicker.launch("image/*")
                                           val uri = ComposeFileProvider.getImageUri(context)
                                           viewModel.imageUri = uri
                                           cameraLauncher.launch(uri)
                                },
                            painter = painterResource(id = R.drawable.ic_addphoto),
                            contentDescription = "Add a photo"
                        )

                    }

                }
                Spacer(modifier = Modifier.size(20.dp))

            }
            SignupBody(modifier = Modifier, navController = navController)
        }

    }


}



@Composable
fun SignupBody(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: ProfileEditViewModel = hiltViewModel(),
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
            validateField = { viewModel.validateCareer()
               }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            careers.careers.forEach { c ->
                DropdownMenuItem(text = { Text(text = c) }, onClick = {
                    expanded = false
                    viewModel.career.value = c
                    viewModel.validateCareer()
                })

            }

        }
        Spacer(modifier = Modifier.size(5.dp))

        ImportantButton(
            modifier = Modifier,
            text = "Actualizar Datos",
            onClick = {viewModel.onUpdate() },
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