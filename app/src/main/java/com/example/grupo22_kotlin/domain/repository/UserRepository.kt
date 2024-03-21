package com.example.grupo22_kotlin.domain.repository

import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User

interface UserRepository {
    suspend fun create(user: User): Response<Boolean>
}