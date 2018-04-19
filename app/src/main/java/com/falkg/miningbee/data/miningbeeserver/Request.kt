package com.falkg.miningbee.data.miningbeeserver

interface Request<out T> {

    companion object {
        internal const val BASE_URL = "http://snowdrop.api.bbci.co.uk/v1"
    }

    fun execute(): T
}