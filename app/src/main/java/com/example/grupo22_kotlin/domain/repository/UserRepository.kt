package com.example.grupo22_kotlin.domain.repository

import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import kotlinx.coroutines.flow.Flow
import java.io.File

interface UserRepository {
    suspend fun create(user: User): Response<Boolean>

    suspend fun update(user: User): Response<Boolean>

    suspend fun saveImage(file: File): Response<String>

    suspend fun addContact(idUser: String, idAddUser: String): Response<Boolean>

    fun getUserById(id: String): Flow<User>
}