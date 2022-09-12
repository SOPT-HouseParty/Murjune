package com.junewon.sopthousparty

import android.app.Application
import com.junewon.sopthousparty.util.TimberDebugTree
import timber.log.Timber

class HousPartyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(TimberDebugTree())
    }
}