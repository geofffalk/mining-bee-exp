package com.falkg.miningbee.feature.recommendations.ui.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.falkg.miningbee.R
import com.falkg.miningbee.feature.recommendations.domain.model.Recommendation
import com.falkg.miningbee.feature.recommendations.domain.model.RecommendationList
import com.falkg.miningbee.util.ctx
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_recommendation.*

class RecommendationListAdapter(private val recommendationList: RecommendationList,
                                private val itemClick: (Recommendation) -> Unit) :
        RecyclerView.Adapter<RecommendationListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_recommendation, parent, false)
        return ViewHolder(view, itemClick)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindRecommendation(recommendationList[position])
    }

    override fun getItemCount() = recommendationList.size

    class ViewHolder(override val containerView: View, private val itemClick: (Recommendation) -> Unit)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindRecommendation(recommendation: Recommendation) {
            with(recommendation) {
                com.squareup.picasso.Picasso.with(itemView.ctx).load(R.drawable.ic_bbc).into(icon)
                titleText.text = this.title
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}