package com.example.grupo22_kotlin.store.presentation.products_screen

import com.example.grupo22_kotlin.store.domain.model.Product

data class ProductsViewState(
    val isLoading: Boolean = false,
    val products : List<Product> = emptyList(),
    val error: String? = null
)
