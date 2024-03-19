package com.example.grupo22_kotlin.store.domain.model

data class NetworkkError(
    val error: ApiError,
    val t: Throwable?  = null

)

enum class ApiError(val message: String){
    NetworkError("Network Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("Unknown Error")
}