package com.example.grupo22_kotlin.presentation.screens.chat

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grupo22_kotlin.domain.model.Post
import com.example.grupo22_kotlin.domain.model.Response
import com.example.grupo22_kotlin.domain.model.User
import com.example.grupo22_kotlin.domain.use_case.auth.AuthUseCases
import com.example.grupo22_kotlin.domain.use_case.users.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userUseCases: UserUseCases,
    private val authUseCases: AuthUseCases
): ViewModel() {


    val currentUser = authUseCases.getCurrentUser()

    var contactsResponse by mutableStateOf<Response<List<User>>?>(null)

    var addContactResponse by mutableStateOf<Response<Boolean>?>(null)
    var userData by mutableStateOf(User())
        private set

    init {
        getContacts()
        //getContacts2()
    }
    fun addContact(idAddContact: String) = viewModelScope.launch {
        addContactResponse = Response.Loading
        val result = userUseCases.addContact(currentUser?.uid?: "", idAddContact)
        addContactResponse = result
    }

    fun getContacts() = viewModelScope.launch {
        contactsResponse = Response.Loading
        userUseCases.getUserById(currentUser!!.uid).collect(){
            userData = it
            val userList = ArrayList<User>()
            userData.contacts.forEach { contact ->
                Log.d( "getContacts: ", contact)
                userUseCases.getUserById(contact).collect(){user ->
                    userList.add(user)
                    //if (userList.size == userData.contacts.size) {
                        contactsResponse = Response.Success(userList)
                    //}
                    //TODO Solve issue related to iterations, we can only
                    //get one contact cause if we try to get more
                    //the program never loads
                }
            }
        }
    }

   /* fun getContacts2() = viewModelScope.launch {
        contactsResponse = Response.Loading
        userUseCases.getUserContacts().collect(){response ->
            contactsResponse = response
        }
    }*/
}