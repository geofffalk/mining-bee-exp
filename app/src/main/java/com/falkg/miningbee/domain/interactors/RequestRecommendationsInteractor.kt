package com.falkg.miningbee.domain.interactors

import com.falkg.miningbee.domain.datasource.RecommendationsProvider
import com.falkg.miningbee.domain.model.RecommendationList

class RequestRecommendationsInteractor(
        private val recommendationsProvider : RecommendationsProvider =
                RecommendationsProvider()) : Interactor<RecommendationList> {

    override fun execute() = recommendationsProvider.requestRecommendationList()
}