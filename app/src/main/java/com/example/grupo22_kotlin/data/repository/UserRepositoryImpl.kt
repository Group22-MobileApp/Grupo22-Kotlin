package com.example.grupo22_kotlin.data.repository

import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.repository.UserRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject



class UserRepositoryImpl  @Inject  constructor(private val usersRef: CollectionReference): UserRepository {
    override suspend fun create(user: User): Response<Boolean> {

        return try {
            usersRef.document(user.id).set(user).await()
            Response.Success(true)

        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)

        }

    }
}