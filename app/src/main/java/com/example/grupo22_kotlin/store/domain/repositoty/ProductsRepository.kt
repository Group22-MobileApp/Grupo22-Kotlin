package com.example.grupo22_kotlin.store.domain.repositoty

import arrow.core.Either
import com.example.grupo22_kotlin.store.domain.model.NetworkkError
import com.example.grupo22_kotlin.store.domain.model.Product

interface  ProductsRepository{

    suspend fun getProducts(): Either<NetworkkError,List<Product>>
}