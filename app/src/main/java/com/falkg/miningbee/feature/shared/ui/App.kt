package com.falkg.miningbee.feature.shared.ui

import android.app.Application
import com.falkg.miningbee.util.DelegatesExt

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}