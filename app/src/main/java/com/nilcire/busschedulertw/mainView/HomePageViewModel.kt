package com.nilcire.busschedulertw.mainView

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nilcire.busschedulertw.ComposeViewModel
import kotlinx.coroutines.*

class HomePageViewModel: ComposeViewModel() {

    var job: Job = viewModelScope.launch(Dispatchers.Default) {
        while (isActive) {
            try {
                Log.d("HomePageViewModel", "HomePageViewModel ${this.hashCode()}: is alive")
                Log.d("HomePageViewModel2", "${Thread.currentThread().name}")
                delay(1000)
            } catch (e: Exception) {
            }
        }
    }

    override fun onStart() {}

    override fun onStop() {
        job.cancel()
    }

    object Instance {
        fun create(): HomePageViewModel {
            return HomePageViewModel()
        }
    }


}