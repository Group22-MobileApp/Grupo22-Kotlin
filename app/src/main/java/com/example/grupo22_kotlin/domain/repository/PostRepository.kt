package com.example.grupo22_kotlin.domain.repository

import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PostRepository {

    suspend fun create(post: Post, file: File): Response<Boolean>
    fun getPosts(): Flow<Response<List<Post>>>
    fun getPostsByUserId(idUser: String): Flow<Response<List<Post>>>
    suspend fun delete(idPost: String): Response<Boolean>

    fun getPostsByUserTaste(userCarrer: String): Flow<Response<List<Post>>>
}