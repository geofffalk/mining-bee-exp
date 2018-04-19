package com.falkg.miningbee.data.miningbeeserver

import com.falkg.miningbee.feature.recommendations.domain.datasource.RecommendationsDataSource
import com.falkg.miningbee.feature.recommendations.domain.model.RecommendationList
import com.falkg.miningbee.feature.videoset.domain.datasource.VideoSetDataSource
import com.falkg.miningbee.feature.videoset.domain.model.VideoSet

class MiningBeeServer(private val dataMapper: ServerDataMapper = ServerDataMapper()) : RecommendationsDataSource, VideoSetDataSource {

    override fun requestRecommendations(): RecommendationList? {
      val result = RecommendationsRequest().execute()
      return dataMapper.convertRecommendationsToDomain(result)
    }

    override fun requestVideoSet(id: String): VideoSet? {
        val result = VideoSetRequest(id).execute()
        return dataMapper.convertVideoSetToDomain(result)

         }

}