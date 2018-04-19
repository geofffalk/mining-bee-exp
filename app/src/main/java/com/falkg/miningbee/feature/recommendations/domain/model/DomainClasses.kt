package com.falkg.miningbee.feature.recommendations.domain.model

import com.falkg.miningbee.feature.shared.domain.model.Image

data class RecommendationList(val id: Long, val title: String, val recommendations: List<Recommendation>) {

    val size: Int
        get() = recommendations.size

    operator fun get(position: Int) = recommendations[position]
}


data class Recommendation(val id: Long, val title: String, val versionId: String, val image: Image)
