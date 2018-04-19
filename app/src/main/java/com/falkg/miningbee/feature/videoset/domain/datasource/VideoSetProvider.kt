package com.falkg.miningbee.feature.videoset.domain.datasource

import com.falkg.miningbee.data.miningbeeserver.MiningBeeServer
import com.falkg.miningbee.feature.videoset.domain.model.VideoSet
import com.falkg.miningbee.util.firstResult

class VideoSetProvider(private val sources: List<VideoSetDataSource> = SOURCES) {

    companion object {
        val SOURCES by lazy { listOf(MiningBeeServer()/* , ADD DB IN FUTURE AND OTHER SOURCES */)}
    }

    fun requestVideoSet(videoId: String) : VideoSet =  requestToSources { it.requestVideoSet(videoId) }

    private fun <T : Any> requestToSources(f: (VideoSetDataSource) -> T?): T = sources.firstResult { f(it) }


}