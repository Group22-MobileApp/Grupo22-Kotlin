package com.example.grupo22_kotlin.domain.use_case.posts

import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.repository.PostRepository
import java.io.File
import javax.inject.Inject


class UpdatePost @Inject constructor(private val repository: PostRepository){

    suspend operator fun invoke(post: Post, file: File?) = repository.update(post, file)

}