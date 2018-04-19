package com.falkg.miningbee.ui

import android.app.Application
import com.falkg.miningbee.extensions.DelegatesExt

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}