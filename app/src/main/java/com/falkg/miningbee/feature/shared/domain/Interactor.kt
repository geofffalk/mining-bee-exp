package com.falkg.miningbee.feature.shared.domain

interface Interactor<out T> {
    fun execute(): T
}