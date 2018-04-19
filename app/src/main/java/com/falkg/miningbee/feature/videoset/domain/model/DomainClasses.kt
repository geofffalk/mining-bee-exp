package com.falkg.miningbee.feature.videoset.domain.model

import com.falkg.miningbee.feature.shared.domain.model.Image

data class VideoSet(val id: Long, val title: String, val mainVideo: Video, val relatedVideos: List<Video>) {
    val size: Int
    get() = relatedVideos.size

    operator fun get(position: Int) = relatedVideos[position]
}


data class Video(val id: String, val image: Image, val title: String, val versionId: String)