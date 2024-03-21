package com.example.grupo22_kotlin.domain.use_case.auth

import com.example.grupo22_kotlin.domain.repository.AuthRepository
import javax.inject.Inject

class LogOut  @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.logout()
}