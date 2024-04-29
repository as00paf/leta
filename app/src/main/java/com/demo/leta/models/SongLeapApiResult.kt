package com.demo.leta.models

sealed class SongLeapApiResult<out T> {
    data class Success<out T>(val data: T): SongLeapApiResult<T>()
    sealed class Error<out T>(val msg: String): SongLeapApiResult<T>()
    data class ApiError<out T>(val message: String, val error: Exception? = null): Error<T>(message)
    data class NetworkError<out T>(val message: String, val error: Exception? = null): Error<T>(message)
}
