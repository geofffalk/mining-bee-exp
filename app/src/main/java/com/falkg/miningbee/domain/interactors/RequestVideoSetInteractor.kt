package com.falkg.miningbee.domain.interactors

import com.falkg.miningbee.domain.datasource.RecommendationsProvider
import com.falkg.miningbee.domain.model.VideoSet

class RequestVideoSetInteractor(val videoId: String,
    private val recommendationsProvider : RecommendationsProvider =
            RecommendationsProvider()) : Interactor<VideoSet> {

    override fun execute(): VideoSet = recommendationsProvider.requestVideoSet(videoId)
}
