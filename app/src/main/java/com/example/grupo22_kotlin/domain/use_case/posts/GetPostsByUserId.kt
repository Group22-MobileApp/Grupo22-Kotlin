package com.example.grupo22_kotlin.domain.use_case.posts

import com.example.grupo22_kotlin.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsByUserId @Inject constructor(private val repository: PostRepository) {

    operator fun invoke(idUser : String) = repository.getPostsByUserId(idUser)

}