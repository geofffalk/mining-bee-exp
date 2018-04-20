package com.falkg.data

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class, sdk = [25])
class MiningBeeServiceTest {

    @Before
    fun setUp() {
        MiningBeeService.init(RuntimeEnvironment.application)
    }

    @Test
    fun testGetRecommendations() {
        val recommendations = MiningBeeService.getRecommendations().blockingFirst()
        print(recommendations)
        Assert.assertTrue(recommendations.isNotEmpty())
    }
}