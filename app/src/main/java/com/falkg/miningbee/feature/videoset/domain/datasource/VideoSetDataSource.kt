package com.falkg.miningbee.feature.videoset.domain.datasource

import com.falkg.miningbee.feature.videoset.domain.model.VideoSet

interface VideoSetDataSource {

    fun requestVideoSet(id: String): VideoSet?
}