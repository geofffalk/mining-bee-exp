package com.falkg.miningbee.feature.shared.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import uk.co.bbc.httpclient.useragent.UserAgent
import uk.co.bbc.smpan.SMP
import uk.co.bbc.smpan.SMPBuilder
import uk.co.bbc.smpan.media.PlayRequest
import uk.co.bbc.smpan.media.model.*
import uk.co.bbc.smpan.playercontroller.media.MediaPosition
import uk.co.bbc.smpan.playercontroller.media.MediaProgress
import uk.co.bbc.smpan.stats.av.AVStatisticsProvider

class SmpView : FrameLayout {

    private val smp: SMP

    // TODO: better user agent
    private val userAgent = UserAgent("MiningBee", "0")

    constructor(context: Context) : super(context) {
        smp = createSmp()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        smp = createSmp()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        smp = createSmp()
    }

    // TODO: integrate echo
    private fun createSmp() = SMPBuilder.create(context, userAgent, EmptyAvStatsProvider(), { _, _ -> }).build()

    fun play(vpid: String) {
        // TODO: mediaSet from config
        // TODO: configure media selector using remote config
        val mediaContentVpid = MediaContentVpid(vpid, userAgent, "mobile-tablet-main")
        val playRequest = PlayRequest.create(
                mediaContentVpid,
                MediaMetadata.MediaType.ONDEMAND,
                MediaMetadata.MediaAvType.VIDEO)
                .withAutoplay(false)
                .with(MediaContentHoldingImage(""))
                .build()
        smp.embeddedPlayoutWindow(playRequest).attachToViewGroup(this)
    }

}

// TODO: integrate Echo
class EmptyAvStatsProvider : AVStatisticsProvider {
    override fun trackScrub(p0: MediaPosition?, p1: MediaPosition?, p2: MutableMap<String, String>?) {
    }

    override fun newSessionStarted(p0: String?, p1: String?, p2: MediaContentIdentifier?, p3: MediaContentEpisodePid?) {
    }

    override fun playbackStoppedOrPaused() {
    }

    override fun trackEnd(p0: MediaProgress?, p1: MutableMap<String, String>?) {
    }

    override fun trackResumed(p0: MediaProgress?) {
    }

    override fun trackError(p0: MediaProgress?) {
    }

    override fun trackOpenConnection() {
    }

    override fun trackBuffering(p0: MediaProgress?) {
    }

    override fun trackPlayInitiated() {
    }

    override fun updateProgress(p0: MediaProgress?) {
    }

    override fun trackPaused(p0: MediaProgress?) {
    }

}
