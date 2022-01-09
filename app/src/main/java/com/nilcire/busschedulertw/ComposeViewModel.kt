package com.nilcire.busschedulertw

import androidx.lifecycle.ViewModel
import kotlin.reflect.KClass

abstract class ComposeViewModel: ViewModel(){

    abstract fun onStart()
    abstract fun onStop()

    object Factory {
        fun <T: ComposeViewModel> create(vmClassName: Class<T>): T {
            return vmClassName.newInstance() as T
        }
    }

}