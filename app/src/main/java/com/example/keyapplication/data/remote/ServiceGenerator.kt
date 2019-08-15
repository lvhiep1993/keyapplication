package com.example.keyapplication.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceGenerator {
    private const val mBaseUrl: String = "https://raw.githubusercontent.com/"

    private val mRetrofitBuilder = Retrofit.Builder()
        .baseUrl(mBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>) = mRetrofitBuilder.build().create(serviceClass)
}