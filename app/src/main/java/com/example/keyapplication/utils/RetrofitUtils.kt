package com.example.keyapplication.utils

import com.example.keyapplication.data.model.ApiResponse
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume

suspend fun <T> Call<T>.await(): ApiResponse<T> = suspendCancellableCoroutine { continuation ->
    enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable) {
            if (continuation.isActive) continuation.resume(ApiResponse.create(t))
        }

        override fun onResponse(call: Call<T>?, response: Response<T>) {
            if (continuation.isActive) continuation.resume(ApiResponse.create(response))
        }
    })
}