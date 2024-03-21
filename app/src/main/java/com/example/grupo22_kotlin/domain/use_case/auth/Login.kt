package com.example.grupo22_kotlin.domain.use_case.auth

import com.example.grupo22_kotlin.data.repository.AuthRepositoryImpl
import com.example.grupo22_kotlin.domain.repository.AuthRepository
import javax.inject.Inject


class Login @Inject constructor(private val repository: AuthRepository){



    suspend operator fun invoke(email: String, password:String) = repository.login(email,password)
}