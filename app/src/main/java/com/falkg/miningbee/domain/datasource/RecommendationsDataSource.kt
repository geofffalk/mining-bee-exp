package com.falkg.miningbee.domain.datasource

import com.falkg.miningbee.domain.model.RecommendationList
import com.falkg.miningbee.domain.model.VideoSet

interface RecommendationsDataSource {

    fun requestRecommendations(): RecommendationList?

    fun requestVideoSet(id: String): VideoSet?
}