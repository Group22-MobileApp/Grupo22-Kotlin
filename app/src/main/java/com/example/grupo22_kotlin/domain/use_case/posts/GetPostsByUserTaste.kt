package com.example.grupo22_kotlin.domain.use_case.posts

import com.example.grupo22_kotlin.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsByUserTaste @Inject constructor(private val repository: PostRepository) {

    operator fun invoke(userCarrer : String) = repository.getPostsByUserTaste(userCarrer)

}