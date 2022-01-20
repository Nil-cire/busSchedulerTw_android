package com.nilcire.busschedulertw

import android.app.Application
import kotlin.properties.Delegates

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        var context: MainApplication by Delegates.notNull()
    }
}