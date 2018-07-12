package com.woong.woong_android.market.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.market.viewholder.MarketNearbyViewHolder
import com.woong.woong_android.seller_market.get.GetNearMarketListResponseData

class MarketNearbyAdapter(private var nearbyItems : ArrayList<GetNearMarketListResponseData>,var requestManager: RequestManager) : RecyclerView.Adapter<MarketNearbyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketNearbyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_market_mymarket,parent,false)
        return MarketNearbyViewHolder(view)
    }

    override fun getItemCount(): Int = nearbyItems.size

    override fun onBindViewHolder(nearbyViewHolder: MarketNearbyViewHolder, position: Int) {
        requestManager.load(nearbyItems[position].title_image_key).into(nearbyViewHolder.img)
        nearbyViewHolder.name.text = nearbyItems[position].market_name
        nearbyViewHolder.address.text = nearbyItems[position].market_address

        var tag : List<String> =nearbyItems[position].tag_name!!.split(",")

        nearbyViewHolder.tag1.text = "#"+tag[0]
        nearbyViewHolder.tag2.text = "#"+tag[1]




    }
}