package com.example.grupo22_kotlin.domain.use_case.users

import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.repository.UserRepository
import javax.inject.Inject

class AddContact @Inject constructor(private  val repository: UserRepository){
    suspend operator fun invoke(idUser: String, idAddContact: String) = repository.addContact(idUser, idAddContact)
}