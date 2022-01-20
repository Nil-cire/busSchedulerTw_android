package com.nilcire.busschedulertw.modules.search

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.nilcire.busschedulertw.ComposeViewModel
import kotlinx.coroutines.*

class SearchPageViewModel: ComposeViewModel() {

    var job: Job = viewModelScope.launch(Dispatchers.Default) {
        while (isActive) {
            try {
                Log.d("SearchPageViewModel", "SearchPageViewModel ${this.hashCode()}: is alive")
                delay(1000)
            } catch (e: Exception) {
            }
        }
    }

    override fun onStart() {
    }

    override fun onStop() {
        job.cancel()
    }

    object Instance {
        fun create(): SearchPageViewModel {
            return SearchPageViewModel()
        }
    }
}