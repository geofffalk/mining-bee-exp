package com.falkg.miningbee.feature.videoset.domain.interactors

import com.falkg.miningbee.feature.shared.domain.Interactor
import com.falkg.miningbee.feature.videoset.domain.datasource.VideoSetProvider
import com.falkg.miningbee.feature.videoset.domain.model.VideoSet

class RequestVideoSetInteractor(val videoId: String,
    private val videoSetProvider : VideoSetProvider =
            VideoSetProvider()) : Interactor<VideoSet> {

    override fun execute(): VideoSet = videoSetProvider.requestVideoSet(videoId)
}
