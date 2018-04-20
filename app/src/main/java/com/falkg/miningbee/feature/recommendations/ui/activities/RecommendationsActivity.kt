package com.falkg.miningbee.feature.recommendations.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.falkg.miningbee.R
import com.falkg.miningbee.feature.recommendations.domain.interactors.RequestRecommendationsInteractor
import com.falkg.miningbee.feature.recommendations.domain.model.RecommendationList
import com.falkg.miningbee.extensions.DelegatesExt
import com.falkg.miningbee.feature.shared.ui.ToolbarManager
import com.falkg.miningbee.feature.videoset.ui.activities.VideoActivity
import com.falkg.miningbee.feature.recommendations.ui.adapters.RecommendationListAdapter
import kotlinx.android.synthetic.main.activity_recommendations.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class RecommendationsActivity : AppCompatActivity(), ToolbarManager {

    private val videoPid: String by DelegatesExt.preference(this, SettingsActivity.VIDEO_PID,
            SettingsActivity.DEFAULT_PID)
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendations)
        initToolbar()

        recommendation_recyclerview.layoutManager = LinearLayoutManager(this)
        attachToScroll(recommendation_recyclerview)
    }

    override fun onResume() {
        super.onResume()
        loadRecommendations()
    }

    private fun loadRecommendations() = async(UI) {
        val result = bg { RequestRecommendationsInteractor().execute() }
        updateUI(result.await())
    }

    private fun updateUI(recommendationList: RecommendationList) {
        val adapter = RecommendationListAdapter(recommendationList) {
            startActivity<VideoActivity>(VideoActivity.VIDEO_ID to /*it.id*/"p05p3k3v",
                    VideoActivity.VIDEO_TITLE to it.title)
        }
        recommendation_recyclerview.adapter = adapter
        toolbarTitle = "${recommendationList.title}"
    }
}
