package com.example.keyapplication.data

import androidx.annotation.VisibleForTesting
import com.example.keyapplication.data.model.ApiResponse
import com.example.keyapplication.data.remote.ApiManager

class KeywordRepository private constructor() {

    private val mApiManager = ApiManager()

    suspend fun loadKeywords(): ApiResponse<List<String>> {
        return mApiManager.loadKeywords()
    }

    companion object {
        private var mInstance: KeywordRepository? = null

        @VisibleForTesting
        fun getmInstance(): KeywordRepository {
            return instance
        }

        val instance: KeywordRepository
            get() {
                if (mInstance == null) {
                    synchronized(KeywordRepository::class.java) {
                        if (mInstance == null) {
                            mInstance = KeywordRepository()
                        }
                    }
                }
                return mInstance!!
            }
    }
}
