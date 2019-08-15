package com.example.keyapplication.data.model

import retrofit2.Response

sealed class ApiResponse<T> {
    companion object {
        fun <T> create(error: Throwable): Failure<T> {
            return Failure(error.message)
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                Success(body)
            } else {
                val serverError = response.errorBody()?.string() ?: response.message()
                Failure(serverError)
            }
        }
    }
}

data class Success<T>(val response: T?) : ApiResponse<T>()

data class Failure<T>(val error: String?) : ApiResponse<T>()
