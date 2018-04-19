package com.falkg.miningbee.feature.recommendations.domain.interactors

import com.falkg.miningbee.feature.shared.domain.Interactor
import com.falkg.miningbee.feature.recommendations.domain.datasource.RecommendationsProvider
import com.falkg.miningbee.feature.recommendations.domain.model.RecommendationList

class RequestRecommendationsInteractor(
        private val recommendationsProvider : RecommendationsProvider =
                RecommendationsProvider()) : Interactor<RecommendationList> {

    override fun execute() = recommendationsProvider.requestRecommendationList()
}