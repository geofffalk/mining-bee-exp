package com.falkg.miningbee.data.miningbeeserver

import com.google.gson.Gson
import java.net.URL

class VideoSetRequest (val id: String = "p05p3k3v", val gson: Gson = Gson()) : Request<VideoSetResult> {

    companion object {
        private const val FULL_URL = "${Request.Companion.BASE_URL}/video"
    }

    override fun execute(): VideoSetResult {
        val remoteConfigResult = RemoteConfigRequest().execute()
        val videoSetJsonStr = URL(remoteConfigResult.videoPageUrlTemplate.replace("\$id", id)).readText()
        return gson.fromJson(videoSetJsonStr, VideoSetResult::class.java)
    }
}
