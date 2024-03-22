package com.example.grupo22_kotlin.presentation.screens.addPost.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.grupo22_kotlin.R
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.components.DialogCapturePicture
import com.example.grupo22_kotlin.presentation.components.ImportantButton
import com.example.grupo22_kotlin.presentation.components.TitleText
import com.example.grupo22_kotlin.presentation.navigation.AuthScreen
import com.example.grupo22_kotlin.presentation.screens.addPost.AddPostViewModel
import com.example.grupo22_kotlin.presentation.screens.signup.SignupViewModel
import com.example.grupo22_kotlin.presentation.ui.theme.Montserrat
import com.example.grupo22_kotlin.presentation.ui.theme.Raleway
import com.example.grupo22_kotlin.presentation.ui.theme.darkBlue
import com.example.grupo22_kotlin.presentation.utils.ComposeFileProvider

@Composable
fun AddPostContent(navController: NavHostController, viewModel: AddPostViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 55.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            AddPostHeader(modifier = Modifier)
            AddPostBody(modifier = Modifier.weight(4f), viewModel)
            /*AddPostFooter(
                modifier = Modifier.weight(1f),
                navController = navController,
                viewModel = viewModel
            )*/
        }
    }
}

@Composable
fun ExclusiveCheckboxes(viewModel: AddPostViewModel) {
    /*var selectedOption1 by remember { mutableStateOf("") }
    var selectedOption2 by remember { mutableStateOf("") }*/

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Column (modifier = Modifier){
            Text(text = "Condition", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Row(
                Modifier
                    .fillMaxWidth(0.5f)
                    .clickable(onClick = { viewModel.selectedOption1.value = "New" }),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = viewModel.selectedOption1.value == "New",
                    onCheckedChange = { if (it) viewModel.selectedOption1.value = "New" }
                )
                Text(text = "New", modifier = Modifier.padding(start = 8.dp))
            }
            Row(
                Modifier
                    .fillMaxWidth(0.5f)
                    .clickable(onClick = { viewModel.selectedOption1.value = "Used" }),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = viewModel.selectedOption1.value == "Used",
                    onCheckedChange = { if (it) viewModel.selectedOption1.value = "Used" }
                )
                Text(text = "Used", modifier = Modifier.padding(start = 8.dp))
            }
        }

        Spacer(modifier = Modifier.size(8.dp))

        Column {
            Text(text = "Interchangeable", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { viewModel.selectedOption2.value = "Yes" }),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = viewModel.selectedOption2.value == "Yes",
                    onCheckedChange = { if (it) viewModel.selectedOption2.value = "Yes" }
                )
                Text(text = "Yes", modifier = Modifier.padding(start = 8.dp))
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { viewModel.selectedOption2.value = "No" }),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = viewModel.selectedOption2.value == "No",
                    onCheckedChange = { if (it) viewModel.selectedOption2.value = "No" },

                )
                Text(text = "No", modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}

@Composable
fun AddPostHeader(modifier: Modifier) {
    Box(modifier = modifier.fillMaxWidth()) {
        TitleText(text = "Create a post")
    }
}

@Composable
fun AddPostBody(
    modifier: Modifier,
    viewModel: AddPostViewModel,
    categories: Categories = Categories()
) {

    viewModel.resultingActivitiHandler.handle()
    var dialogState = remember { mutableStateOf(false) }
    DialogCapturePicture(status = dialogState,
        takePhoto = { viewModel.takePhoto() },
        pickImage = {viewModel.pickImage()})

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(30.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
            border = BorderStroke(width = 1.1.dp, color = Color.LightGray)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Take or add a photo", color = Color.Gray)
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    if(viewModel.image.value != ""){
                        AsyncImage(
                            modifier = Modifier.height(100.dp)
                                .clip(CircleShape)
                                .clickable {
                                           dialogState.value = true
                                },                            model = viewModel.image.value,
                            contentDescription = ""
                        )
                    }else{
                        Image(
                            modifier = Modifier
                                .size(95.dp)
                                .clickable {
                                    dialogState.value = true
                                },
                            painter = painterResource(id = R.drawable.ic_addphoto),
                            contentDescription = "Add a photo"
                        )

                    }

                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        DefaultTextField(
            modifier = Modifier,
            value = viewModel.name.value,
            onValueChange = { viewModel.name.value = it },
            label = "Name",
            errorMsg = viewModel.nameErrMsg.value,
            validateField = { viewModel.validateName() }
        )
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.price.value,
            onValueChange = {
                if (it.length <= 10 && it.all { char -> char.isDigit() }) viewModel.price.value =
                    it
            },
            label = "Price",
            errorMsg = viewModel.priceErrMsg.value,
            validateField = { viewModel.validatePrice() },
            keyboardType = KeyboardType.Number
        )

        var expanded by remember { mutableStateOf(false) }
        Column() {
            DefaultTextField(
                modifier = Modifier
                    .clickable { expanded = true },
                value = viewModel.category.value,
                onValueChange = { viewModel.category.value = it },
                enabled = false,
                readOnly = false,
                label = "Categorie",
                errorMsg = viewModel.categoryErrMsg.value,
                validateField = { viewModel.validateCategory() },
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
                    .requiredSizeIn(maxHeight = 235.dp)
            ) {
                categories.categories.forEach { c ->
                    DropdownMenuItem(text = { Text(text = c, fontFamily = Montserrat) }, onClick = {
                        expanded = false
                        viewModel.category.value = c
                        viewModel.validateCategory()
                    })
                }
            }
        }
        DefaultTextField(
            modifier = Modifier,
            value = viewModel.description.value,
            onValueChange = { viewModel.description.value = it },
            label = "Description",
            errorMsg = viewModel.descriptionErrMsg.value,
            validateField = { viewModel.validateDescription() },
        )
        ExclusiveCheckboxes(viewModel)

        Spacer(modifier = Modifier.size(16.dp))

        ImportantButton(
            modifier = Modifier,
            text = "Post",
            onClick = { viewModel.onNewPost() },
            enabled = viewModel.isEnabledPostButton
        )
    }
}

@Composable
fun AddPostFooter(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: AddPostViewModel
) {
    Box(modifier = modifier.fillMaxWidth()) {
        ImportantButton(
            modifier = Modifier,
            text = "Create",
            onClick = { navController.navigate(route = AuthScreen.Login.route) },
            enabled = viewModel.isEnabledPostButton
        )
    }

}