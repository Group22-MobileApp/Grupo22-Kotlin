package com.example.grupo22_kotlin.di

import com.example.grupo22_kotlin.core.Constants.USERS
import com.example.grupo22_kotlin.data.repository.AuthRepositoryImpl
import com.example.grupo22_kotlin.data.repository.UserRepositoryImpl
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.repository.AuthRepository
import com.example.grupo22_kotlin.domain.repository.UserRepository
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.auth.GetCurrentUser
import com.example.grupo22_kotlin.domain.use_case.auth.LogOut
import com.example.grupo22_kotlin.domain.use_case.auth.Login
import com.example.grupo22_kotlin.domain.use_case.auth.Signup
import com.example.grupo22_kotlin.domain.use_case.users.Create
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

    @Provides
    fun provideUsersRef(db: FirebaseFirestore): CollectionReference = db.collection(USERS)
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl

    @Provides
    fun provideUsersRepository(impl: UserRepositoryImpl): UserRepository = impl

    @Provides
    fun provideAuthUseCases(repository: AuthRepository)= AuthUseCases(
        getCurrentUser = GetCurrentUser(repository),
        login = Login(repository),
        logOut = LogOut(repository),
        signup = Signup(repository)
    )

    @Provides
    fun provideUsersUseCases(repository: UserRepository) = UserUseCases(
        create = Create(repository)
    )
}