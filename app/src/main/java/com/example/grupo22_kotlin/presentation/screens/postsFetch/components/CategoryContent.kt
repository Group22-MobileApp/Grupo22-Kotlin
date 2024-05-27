package com.example.grupo22_kotlin.presentation.screens.postsFetch.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.grupo22_kotlin.presentation.components.DefaultTextField
import com.example.grupo22_kotlin.presentation.components.TitleText
import com.example.grupo22_kotlin.presentation.screens.addPost.components.Categories
import com.example.grupo22_kotlin.presentation.screens.postsFetch.PostsFetchViewModel
import com.example.grupo22_kotlin.presentation.ui.theme.Montserrat

@Composable
fun CategoryContent(
    navController: NavHostController,
    categories: Categories = Categories(),
    viewModel: PostsFetchViewModel = hiltViewModel()
) {

    //val categories = Categories()

    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp, top = 55.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            TitleText(text = "Categories")
            DefaultTextField(
                modifier = Modifier
                    .clickable { expanded = true },
                value = viewModel.category.value,
                onValueChange = { viewModel.category.value = it },
                enabled = false,
                readOnly = false,
                label = "Categories",
                errorMsg = viewModel.categoryErrMsg.value,
                validateField = { },
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
                        viewModel.getPostsByCategory(c)
                    })
                }
            }
            GetPostsByCategory(navController = navController)
        }
    }
}