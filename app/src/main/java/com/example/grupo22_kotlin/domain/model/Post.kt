package com.example.grupo22_kotlin.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Post(

    var id: String = "",
    var name: String = "",
    var description: String = "",
    var price: String = "",
    var category: String = "",
    var condition: String = "",
    var interchangeable: String = "",
    var image: String = "",
    var idUser: String = "",
    var userCarrer: String = "",
    var views: String = "",
    var user: User? = null,
    var likes: ArrayList<String> = ArrayList(),
    var reviews: ArrayList<String> = ArrayList()
){
    fun toJson(): String = Gson().toJson(Post(
        id,
        name,
        description,
        price,
        category,
        condition,
        interchangeable,
        if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
        idUser,
        userCarrer,
        views,
        User(
            id = user?.id ?: "",
            username = user?.username ?: "",
            email = user?.email ?: "",
            career = user?.career?: "",
            image =
            if (!user?.image.isNullOrBlank())
                URLEncoder.encode(user?.image, StandardCharsets.UTF_8.toString())
            else "",
        ),
        likes,
        reviews
    ))

    companion object {
        fun fromJson(data: String): Post = Gson().fromJson(data, Post::class.java)
    }
}
