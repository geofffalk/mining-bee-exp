package com.falkg.miningbee.domain.datasource

import com.falkg.miningbee.data.miningbeeserver.MiningBeeServer
import com.falkg.miningbee.domain.model.RecommendationList
import com.falkg.miningbee.domain.model.VideoSet
import com.falkg.miningbee.extensions.firstResult

class RecommendationsProvider(private val sources: List<RecommendationsDataSource> = RecommendationsProvider.SOURCES) {

    companion object {
        val SOURCES by lazy { listOf(MiningBeeServer()/* , ADD DB IN FUTURE AND OTHER SOURCES */)}
    }

    fun requestRecommendationList() : RecommendationList = requestToSources { it.requestRecommendations() }

    fun requestVideoSet(videoId: String) : VideoSet =  requestToSources { it.requestVideoSet(videoId) }

    private fun <T : Any> requestToSources(f: (RecommendationsDataSource) -> T?): T = sources.firstResult { f(it) }


}