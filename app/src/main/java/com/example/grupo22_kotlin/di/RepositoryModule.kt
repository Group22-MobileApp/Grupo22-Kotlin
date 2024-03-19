package com.example.grupo22_kotlin.di

import com.example.grupo22_kotlin.store.data.repository.ProductsRepositoryImpl
import com.example.grupo22_kotlin.store.domain.repositoty.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract  fun bindProductsRepository(impl: ProductsRepositoryImpl): ProductsRepository
}