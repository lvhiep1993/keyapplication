package com.example.keyapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.keyapplication.data.KeywordRepository
import com.example.keyapplication.data.model.Failure
import com.example.keyapplication.data.model.Success
import com.example.keyapplication.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class MainViewModel : ViewModel() {

    private var mUIState: MutableLiveData<UIModelWrapper> = MutableLiveData()

    fun getUIState(): MutableLiveData<UIModelWrapper> {
        return mUIState
    }

    fun loadKeyword() {
        CoroutineScope(Dispatchers.Default).launch {
            val apiResponse = KeywordRepository.instance.loadKeywords()
            if (apiResponse is Success) {
                val formattedKeywords = Utils.formatKeywords(apiResponse.response)
                emitUIState(showKeywords = formattedKeywords)
            } else if (apiResponse is Failure) {
                emitUIState(showServerError = apiResponse.error)
            }
        }
    }

    private fun emitUIState(
        showKeywords: List<String>? = null,
        showServerError: String? = null
    ) {
        val uiModelWrapper = UIModelWrapper(showKeywords, showServerError)
        mUIState.postValue(uiModelWrapper)
    }

    data class UIModelWrapper(
        var showKeywords: List<String>?,
        var showServerError: String?
    )
}
