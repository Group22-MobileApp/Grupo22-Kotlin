package com.example.grupo22_kotlin.domain.use_case.users

import com.example.grupo22_kotlin.domain.repository.UserRepository
import java.io.File
import javax.inject.Inject

class SaveImage  @Inject constructor(private val repository: UserRepository){

    suspend operator fun invoke(file: File) = repository.saveImage(file)
}