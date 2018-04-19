package com.falkg.miningbee.data.miningbeeserver

import com.google.gson.Gson
import java.net.URL

class RemoteConfigRequest(val gson: Gson = Gson()) : Request<RemoteConfigResult> {

    companion object {
        private const val CONFIG_URL = "http://snowdrop.api.bbci.co.uk/app-config/android/3.0.0/config.json"
    }

    override fun execute(): RemoteConfigResult {
        val remoteConfigJsonStr = URL(CONFIG_URL).readText()
        return gson.fromJson(remoteConfigJsonStr, RemoteConfigResult::class.java)
    }

}