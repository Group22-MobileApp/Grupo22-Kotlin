package com.example.grupo22_kotlin.domain.repository

import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PostRepository {

    suspend fun create(post: Post, file: File): Response<Boolean>
    suspend fun update(post: Post, file: File?): Response<Boolean>
    suspend fun delete(idPost: String): Response<Boolean>

    suspend fun like(idPost: String, idUser: String): Response<Boolean>
    suspend fun deleteLike(idPost: String, idUser: String): Response<Boolean>



    fun getPosts(): Flow<Response<List<Post>>>
    fun getPostsByUserId(idUser: String): Flow<Response<List<Post>>>

    fun getPostThatILiked(idUser: String): Flow<Response<List<Post>>>
    fun getPostsByUserTaste(userCarrer: String): Flow<Response<List<Post>>>
    fun getPostsByCategory(category: String): Flow<Response<List<Post>>>
    suspend fun updateViews(idPost: String, newViews: String) : Response<Boolean>
}