package com.gateway.marvel.network

sealed class ResponseWrapper<out T> {
    data class Success<out T>(val value: T) : ResponseWrapper<T>()

    data class Failure(val msg: String) : ResponseWrapper<Nothing>()

    data class LocalFailure(val msgRes: Int) : ResponseWrapper<Nothing>()

    object Loading : ResponseWrapper<Nothing>()
}