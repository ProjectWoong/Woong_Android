package com.woong.woong_android.market.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.market.data.MarketNearbyData
import com.woong.woong_android.market.viewholder.MarketNearbyViewHolder

class MarketNearbyAdapter(private var nearbyItems : ArrayList<MarketNearbyData>) : RecyclerView.Adapter<MarketNearbyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketNearbyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_market_mymarket,parent,false)
        return MarketNearbyViewHolder(view)
    }

    override fun getItemCount(): Int = nearbyItems.size

    override fun onBindViewHolder(nearbyViewHolder: MarketNearbyViewHolder, position: Int) {
        nearbyViewHolder.img.setImageResource(nearbyItems[position].nb_img)
        nearbyViewHolder.name.text = nearbyItems[position].nb_name
        nearbyViewHolder.address.text = nearbyItems[position].nb_address
        nearbyViewHolder.tag1.text = nearbyItems[position].nb_tag1
        nearbyViewHolder.tag2.text = nearbyItems[position].nb_tag2
        nearbyViewHolder.tag3.text = nearbyItems[position].nb_tag3
    }
}