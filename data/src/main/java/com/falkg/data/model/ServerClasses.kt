package com.falkg.miningbee.data.miningbeeserver

data class RecommendationsResult(val recommendations: List<Recommendation>)
data class VideoSetResult(val current: Video, val relatedVideos: List<Video>)

data class RemoteConfigResult(val killed: Boolean, val recommendationsUrl: String, val upgrade: String,
                        val videoPageUrlTemplate: String)
data class Video(val id: String, val image: Image, val title: String, val versionId: String)
data class Image(val altText: String, val urlTemplate: String)

data class Recommendation(val id: String, val title: String, val versionId: String, val image: Image)




