package com.example.grupo22_kotlin.di

import com.example.grupo22_kotlin.data.repository.AuthRepositoryImpl
import com.example.grupo22_kotlin.domain.repository.AuthRepository
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.auth.GetCurrentUser
import com.example.grupo22_kotlin.domain.use_case.auth.LogOut
import com.example.grupo22_kotlin.domain.use_case.auth.Login
import com.example.grupo22_kotlin.domain.use_case.auth.Signup
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository)= AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logOut = LogOut(repository),
        signup = Signup(repository)
    )
}