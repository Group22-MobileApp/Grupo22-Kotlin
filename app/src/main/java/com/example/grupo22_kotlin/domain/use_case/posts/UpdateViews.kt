package com.example.grupo22_kotlin.domain.use_case.posts

import com.example.grupo22_kotlin.domain.repository.PostRepository
import javax.inject.Inject


class UpdateViews @Inject constructor(private val repository: PostRepository) {

    suspend operator fun invoke(idPost: String, newViews: String) = repository.updateViews(idPost, newViews)

}