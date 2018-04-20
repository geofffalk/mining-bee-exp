package com.falkg.data.api

import android.content.Context
import com.falkg.miningbee.data.miningbeeserver.RecommendationsResult
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import java.io.File
import java.util.concurrent.TimeUnit


internal interface MiningBeeApi {

    companion object Factory {

        var INSTANCE: MiningBeeApi? = null

        const val BASE_URL = "http://snowdrop.api.bbci.co.uk/v1/"

        fun create(context: Context): MiningBeeApi? {

            if (INSTANCE == null) {
                val client = OkHttpClient.Builder()
                        .cache(Cache(File(context.cacheDir, "okhttp"), 10 * 1024 * 1024L))
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .writeTimeout(10, TimeUnit.SECONDS)
                        .build()

                val gson = GsonBuilder().setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'").create()

                val retrofit = Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(client)
                        .baseUrl(BASE_URL)
                        .build()

                INSTANCE = retrofit.create<MiningBeeApi>(MiningBeeApi::class.java!!)
            }

            return INSTANCE
        }
    }

    @GET("recommendations")
    fun getRecommendations() : Observable<RecommendationsResult>

}