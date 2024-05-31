package com.example.grupo22_kotlin.data.repository

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.snapshotFlow
import com.example.grupo22_kotlin.core.Constants.USERS
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.repository.UserRepository
import com.example.grupo22_kotlin.domain.use_case.users.AddContact
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named


class UserRepositoryImpl  @Inject  constructor(
    @Named(USERS) private val usersRef: CollectionReference,
    private val storaUsersRef: StorageReference): UserRepository {
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

    override suspend fun saveImage(file: File): Response<String> {

        return try {
            val fromFile = Uri.fromFile(file)
            val ref = storaUsersRef.child(file.name)
            val uploadTask = ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()
            return  Response.Success(url.toString())

        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)

        }

    }

    override suspend fun addContact(idUser: String, idAddContact: String): Response<Boolean> {
        return try {
            usersRef.document(idUser).update("contacts", FieldValue.arrayUnion(idAddContact)).await()
            usersRef.document(idAddContact).update("contacts", FieldValue.arrayUnion(idUser)).await()
            Response.Success(true)
        } catch (e: Exception) {
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

    override fun getUserContacts(userId: String): Flow<Response<List<User>>> = callbackFlow {
        val snapshotListener = usersRef.document(userId).addSnapshotListener { snapshot, e ->
            launch(Dispatchers.IO) {
                val usersResponse = if (snapshot != null && snapshot.exists()) {
                    val user = snapshot.toObject(User::class.java)
                    if (user != null) {
                        // Fetch the contacts of the user
                        val contacts = user.contacts.mapNotNull { contactId ->
                            try {
                                val contactSnapshot = usersRef.document(contactId).get().await()
                                contactSnapshot.toObject(User::class.java)
                            } catch (ex: Exception) {
                                Log.e("Firestore", "Error fetching contact $contactId", ex)
                                null
                            }
                        }
                        Response.Success(contacts)
                    } else {
                        Response.Failure(NullPointerException("User not found"))
                    }
                } else {
                    Response.Failure(e)
                }
                trySend(usersResponse)
            }
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

}