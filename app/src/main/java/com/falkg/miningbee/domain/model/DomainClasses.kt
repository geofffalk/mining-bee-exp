package com.falkg.miningbee.domain.model

data class RecommendationList(val id: Long, val title: String, val recommendations: List<Recommendation>) {

    val size: Int
        get() = recommendations.size

    operator fun get(position: Int) = recommendations[position]
}

data class VideoSet(val id: Long, val title: String, val mainVideo: Video, val relatedVideos: List<Video>) {
    val size: Int
    get() = relatedVideos.size

    operator fun get(position: Int) = relatedVideos[position]
}

data class Recommendation(val id: Long, val title: String, val versionId: String, val image: Image)

data class Video(val id: String, val image: Image, val title: String, val versionId: String)

data class Image(val altText: String, val urlTemplate: String)