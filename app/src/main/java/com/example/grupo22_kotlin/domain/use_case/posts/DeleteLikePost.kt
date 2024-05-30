package com.example.grupo22_kotlin.domain.use_case.posts

import com.example.grupo22_kotlin.domain.repository.PostRepository
import javax.inject.Inject

class DeleteLikePost @Inject constructor(private val repository: PostRepository) {

    suspend operator fun invoke(idPost: String, idUser: String) = repository.deleteLike(idPost, idUser)

}