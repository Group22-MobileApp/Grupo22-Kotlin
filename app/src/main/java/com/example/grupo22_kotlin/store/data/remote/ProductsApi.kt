package com.example.grupo22_kotlin.store.data.remote

import com.example.grupo22_kotlin.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}