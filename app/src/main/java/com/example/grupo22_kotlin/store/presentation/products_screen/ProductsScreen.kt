package com.example.grupo22_kotlin.store.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.grupo22_kotlin.store.presentation.products_screen.components.ProductCart
import com.example.grupo22_kotlin.store.presentation.util.componenets.LoadingDialog
import com.example.grupo22_kotlin.store.presentation.util.componenets.MyTopAppBar

@Composable
internal fun ProductsScreen(
     viewModel: ProductViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductsContent(state = state)
}

@OptIn(ExperimentalMaterial3Api:: class)
@Composable
fun ProductsContent(
    state: ProductsViewState
){
 LoadingDialog(isLoading = state.isLoading)
    Scaffold(modifier= Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(title = "products")
        }) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
            ){
            
            items(state.products) {product->
                ProductCart(product = product)
                
            }
        }

    }
}