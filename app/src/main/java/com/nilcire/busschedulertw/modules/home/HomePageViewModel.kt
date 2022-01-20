package com.nilcire.busschedulertw.mainView.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nilcire.busschedulertw.ComposeViewModel
import kotlinx.coroutines.*

class HomePageViewModel: ComposeViewModel() {

    var count: MutableLiveData<Int> = MutableLiveData(0)

    fun addOne() {
        count.value = count.value?.plus(1)
    }

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