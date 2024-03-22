package com.example.grupo22_kotlin.data.repository

import androidx.compose.runtime.snapshotFlow
import com.example.grupo22_kotlin.core.Constants.USERS
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.repository.UserRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named


class UserRepositoryImpl  @Inject  constructor(
    @Named(USERS) private val usersRef: CollectionReference): UserRepository {
    override suspend fun create(user: User): Response<Boolean> {

        return try {
            usersRef.document(user.id).set(user).await()
            Response.Success(true)

        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)

        }

    }

    override suspend fun update(
       user: User
    ): Response<Boolean> {
        return try {
            val map: MutableMap<String, Any> = HashMap()
            map["username"] = user.username
            map["image"] = user.image
            map["number"] = user.number
            map["career"] = user.career
            usersRef.document(user.id).update(map).await()
            Response.Success(true)

        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)

        }
    }

    override fun getUserById(id: String): Flow<User> = callbackFlow {
        val snapshotListener = usersRef.document(id).addSnapshotListener { snapshot , e ->
            val user = snapshot?.toObject(User::class.java) ?: User()
            trySend(user)
        }
        awaitClose{
            snapshotListener.remove()
        }
    }
}