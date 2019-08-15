package com.example.keyapplication.data.remote

import com.base.kulturely.data.remote.base.BaseManager
import com.example.keyapplication.data.model.ApiResponse
import com.example.keyapplication.utils.await


class ApiManager : BaseManager<ApiService>(ApiService::class.java) {

    suspend fun loadKeywords(): ApiResponse<List<String>> {
        return service.loadKeywords().await()
    }
}