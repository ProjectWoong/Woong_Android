package com.woong.woong_android.map

import android.view.View
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.woong.woong_android.R

class LocationSearchViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var address : TextView = itemView!!.findViewById(R.id.item_address_join_location) as TextView
    var road : TextView = itemView!!.findViewById(R.id.item_road_join_location) as TextView
}