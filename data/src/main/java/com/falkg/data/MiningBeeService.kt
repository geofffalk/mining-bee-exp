package com.falkg.data

import android.content.Context
import com.falkg.data.api.MiningBeeApi
import com.falkg.data.exception.MiningBeeServiceException
import com.falkg.miningbee.data.miningbeeserver.Recommendation
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

object MiningBeeService {

    fun init(context: Context) {
        MiningBeeApi.create(context)
    }

    fun getRecommendations(): Observable<List<Recommendation>> =
            MiningBeeApi.INSTANCE!!.getRecommendations()
                    .subscribeOn(Schedulers.io())
                    .map {
                        it.recommendations
                    }
                    .onErrorResumeNext { err: Throwable ->
                        throw MiningBeeServiceException(err.message)
                    }
}