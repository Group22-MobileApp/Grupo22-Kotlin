package com.example.grupo22_kotlin.domain.model

import com.google.gson.Gson

data class User(
    var id: String = "",
    var username: String ="",
    var email: String ="",
    var password: String ="",
    var number: String ="",
    var career: String ="",


) {
    fun  toJson(): String = Gson().toJson(this)

    companion object{
        fun fromJson(data:String): User =Gson().fromJson(data, User::class.java)
    }
}