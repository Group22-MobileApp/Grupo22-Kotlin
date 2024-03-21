package com.example.grupo22_kotlin.domain.use_case.auth

import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.repository.AuthRepository
import javax.inject.Inject

class Signup @Inject constructor(private val repository: AuthRepository) {

    suspend operator  fun  invoke(user: User) = repository.signUp(user)
}