package com.example.grupo22_kotlin.store.data.mapper


import com.example.grupo22_kotlin.store.domain.model.ApiError
import com.example.grupo22_kotlin.store.domain.model.NetworkkError
import java.io.IOException
import retrofit2.HttpException

fun Throwable.toNetworkError(): NetworkkError{
    val error = when(this){
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkkError(
        error = error,
        t = this
    )
}