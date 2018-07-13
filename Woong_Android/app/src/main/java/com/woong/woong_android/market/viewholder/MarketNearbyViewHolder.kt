package com.woong.woong_android.market.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R

class MarketNearbyViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var img : ImageView = itemView!!.findViewById(R.id.iv_market_market) as ImageView
    var name : TextView = itemView!!.findViewById(R.id.tv_name_market) as TextView
    var address : TextView = itemView!!.findViewById(R.id.tv_address_market) as TextView
    var tag1 : TextView = itemView!!.findViewById(R.id.tv_tag1_market) as TextView
    var tag2 : TextView = itemView!!.findViewById(R.id.tv_tag2_market) as TextView
    var label : ImageView = itemView!!.findViewById(R.id.iv_bookmark_market) as ImageView
}