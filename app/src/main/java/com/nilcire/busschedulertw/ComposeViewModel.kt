package com.nilcire.busschedulertw

import androidx.lifecycle.ViewModel

abstract class ComposeViewModel: ViewModel(){

    var state: ComposeViewModelState = ComposeViewModelState.IsStarted

    abstract fun onStart()
    abstract fun onStop()

    object Factory {
        fun <T: ComposeViewModel> create(vmClassName: Class<T>): T {
            return vmClassName.newInstance() as T
        }
    }

}

enum class ComposeViewModelState {
    IsStarted,
    IsStopped,
}