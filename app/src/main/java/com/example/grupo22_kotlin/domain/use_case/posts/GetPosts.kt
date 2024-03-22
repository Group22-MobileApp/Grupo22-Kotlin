package com.example.grupo22_kotlin.domain.use_case.posts

import com.example.grupo22_kotlin.domain.repository.PostRepository
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: PostRepository) {

    operator fun invoke() = repository.getPosts()

}