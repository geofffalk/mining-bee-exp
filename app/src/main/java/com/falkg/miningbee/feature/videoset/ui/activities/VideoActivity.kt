package com.falkg.miningbee.feature.videoset.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.falkg.miningbee.R
import com.falkg.miningbee.feature.videoset.domain.interactors.RequestVideoSetInteractor
import com.falkg.miningbee.feature.videoset.domain.model.VideoSet
import com.falkg.miningbee.feature.videoset.ui.adapters.VideoSetAdapter
import kotlinx.android.synthetic.main.activity_video.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.startActivity

class VideoActivity : AppCompatActivity() {

    companion object {
        const val VIDEO_ID = "VideoActivity:id"
        const val VIDEO_TITLE = "VideoActivity:title"
    }

    lateinit var videoId : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoId = intent.getStringExtra(VIDEO_ID)

        relatedVideos.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        currentVideo.play(videoId)
        currentTitle.text = intent.getStringExtra(VIDEO_TITLE)
        loadRelatedVideos()
    }

    private fun loadRelatedVideos() = async(UI) {
        val result = bg { RequestVideoSetInteractor(videoId).execute() }
        updateUI(result.await())
    }

    private fun updateUI(videoSet: VideoSet) {
        val adapter = VideoSetAdapter(videoSet) {
            startActivity<VideoActivity>(VIDEO_ID to it.id,
                    VIDEO_TITLE to it.title)
        }
        relatedVideos.adapter = adapter
    }

}
