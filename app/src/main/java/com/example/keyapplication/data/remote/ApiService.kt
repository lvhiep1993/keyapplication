package com.example.keyapplication.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("tikivn/android-home-test/v2/keywords.json")
    fun loadKeywords(): Call<List<String>>
}