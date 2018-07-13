package com.woong.woong_android.home.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R

class MarketBookmarkViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var marketimg: ImageView = itemView!!.findViewById(R.id.iv_market_bookmark) as ImageView
    var marketname: TextView = itemView!!.findViewById(R.id.tv_name_bookmark) as TextView
    var address: TextView = itemView!!.findViewById(R.id.tv_address_bookmark) as TextView
    var bookmark: ImageView = itemView!!.findViewById(R.id.iv_btn_bookmark) as ImageView
}