package com.falkg.miningbee.domain.interactors

interface Interactor<out T> {
    fun execute(): T
}