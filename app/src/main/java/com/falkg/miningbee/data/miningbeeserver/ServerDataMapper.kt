package com.falkg.miningbee.data.miningbeeserver

import com.falkg.miningbee.feature.recommendations.domain.model.RecommendationList
import com.falkg.miningbee.feature.recommendations.domain.model.Recommendation as ModelRecommendation
import com.falkg.miningbee.feature.videoset.domain.model.VideoSet as ModelVideoSet
import com.falkg.miningbee.feature.videoset.domain.model.Video as ModelVideo
import com.falkg.miningbee.feature.shared.domain.model.Image as ModelImage

class ServerDataMapper {

    fun convertRecommendationsToDomain(recommendationResult : RecommendationsResult) = with(recommendationResult) {
        RecommendationList(0, "Today's recommendations", convertRecommendationListToDomain(recommendations))
    }

    private fun convertRecommendationListToDomain(list: List<Recommendation>): List<ModelRecommendation> {
        return list.mapIndexed{i, recommendation-> convertRecommendationToDomain(recommendation)}
    }

    fun convertVideoSetToDomain(videoResult: VideoSetResult) = with(videoResult) {
        ModelVideoSet(0,
                current.title,
                ModelVideo(current.id, convertImageToDomain(current.image), current.title, current.versionId),
                convertVideoListToDomain(relatedVideos))
    }

    fun convertVideoListToDomain(list : List<Video>) = list.map { video -> convertVideoToDomain(video) }

    private fun convertVideoToDomain(video: Video) = with(video) {ModelVideo(id, convertImageToDomain(image), title, versionId)}

    private fun convertRecommendationToDomain(recommendation: Recommendation) = with (recommendation) { ModelRecommendation(0,
            title, versionId, convertImageToDomain(image)) }


    private fun convertImageToDomain(image: Image) = ModelImage(image.altText, image.urlTemplate)


}