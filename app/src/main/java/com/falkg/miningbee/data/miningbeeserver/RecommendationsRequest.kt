package com.falkg.miningbee.data.miningbeeserver

import com.google.gson.Gson
import java.net.URL

class RecommendationsRequest(val gson: Gson = Gson()) : Request<RecommendationsResult> {

    companion object {
        private const val URL = "${Request.Companion.BASE_URL}/recommendations"
    }

    override fun execute(): RecommendationsResult {
        val remoteConfigResult = RemoteConfigRequest().execute()
        val recommendationsJsonStr = URL(remoteConfigResult.recommendationsUrl).readText()

        return gson.fromJson(recommendationsJsonStr, RecommendationsResult::class.java)
    }
}
