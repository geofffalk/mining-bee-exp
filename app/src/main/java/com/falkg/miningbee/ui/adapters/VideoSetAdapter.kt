package com.falkg.miningbee.ui.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.falkg.miningbee.R
import com.falkg.miningbee.domain.model.Recommendation
import com.falkg.miningbee.domain.model.RecommendationList
import com.falkg.miningbee.domain.model.Video
import com.falkg.miningbee.domain.model.VideoSet
import com.falkg.miningbee.extensions.ctx
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recommendation.*


class VideoSetAdapter(private val videoSet: VideoSet,
                      private val itemClick: (Video) -> Unit) :
        RecyclerView.Adapter<VideoSetAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_recommendation, parent, false)
        return ViewHolder(view, itemClick)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindRecommendation(videoSet[position])
    }

    override fun getItemCount() = videoSet.size

    class ViewHolder(override val containerView: View, private val itemClick: (Video) -> Unit)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindRecommendation(video: Video) {
            with(video) {
                com.squareup.picasso.Picasso.with(itemView.ctx).load(R.drawable.ic_bbc).into(icon)
                titleText.text = this.title
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}