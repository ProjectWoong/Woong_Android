package com.woong.woong_android.seller_market.album

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R

class AlbumViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
    var albumDate : TextView = itemView!!.findViewById(R.id.date_sellermarket_album) as TextView
    var albumPhoto : ImageView = itemView!!.findViewById(R.id.photo_sellermarket_album) as ImageView
    val albumContent : TextView = itemView!!.findViewById(R.id.content_sellermarket_album) as TextView
}