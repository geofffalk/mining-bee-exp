package com.falkg.miningbee.feature.recommendations.domain.datasource

import com.falkg.miningbee.data.miningbeeserver.MiningBeeServer
import com.falkg.miningbee.feature.recommendations.domain.model.RecommendationList
import com.falkg.miningbee.util.firstResult

class RecommendationsProvider(private val sources: List<RecommendationsDataSource> = SOURCES) {

    companion object {
        val SOURCES by lazy { listOf(MiningBeeServer()/* , ADD DB IN FUTURE AND OTHER SOURCES */)}
    }

    fun requestRecommendationList() : RecommendationList = requestToSources { it.requestRecommendations() }

    private fun <T : Any> requestToSources(f: (RecommendationsDataSource) -> T?): T = sources.firstResult { f(it) }


}