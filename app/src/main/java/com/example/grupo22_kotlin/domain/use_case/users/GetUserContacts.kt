package com.example.grupo22_kotlin.domain.use_case.users

import com.example.grupo22_kotlin.domain.repository.PostRepository
import com.example.grupo22_kotlin.domain.repository.UserRepository
import javax.inject.Inject

class GetUserContacts @Inject constructor(private val repository: UserRepository) {

    operator fun invoke(userId: String) = repository.getUserContacts(userId)

}