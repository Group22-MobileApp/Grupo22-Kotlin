package com.example.grupo22_kotlin.store.data.repository

import arrow.core.Either
import com.example.grupo22_kotlin.store.data.mapper.toNetworkError
import com.example.grupo22_kotlin.store.data.remote.ProductsApi
import com.example.grupo22_kotlin.store.domain.model.NetworkkError
import com.example.grupo22_kotlin.store.domain.model.Product
import com.example.grupo22_kotlin.store.domain.repositoty.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi
): ProductsRepository {

    override suspend fun getProducts(): Either<NetworkkError, List<Product>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }
}