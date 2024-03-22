package com.example.grupo22_kotlin.domain.model

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
    var user: User? = null,
    var likes: ArrayList<String> = ArrayList()
){

}
