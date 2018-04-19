package com.falkg.miningbee.feature.recommendations.domain.datasource

import com.falkg.miningbee.feature.recommendations.domain.model.RecommendationList

interface RecommendationsDataSource {

    fun requestRecommendations(): RecommendationList?
}