package com.example.grupo22_kotlin.domain.use_case.users

import com.example.grupo22_kotlin.domain.repository.UserRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val repository: UserRepository){
    operator fun invoke(id: String) = repository.getUserById(id)
}