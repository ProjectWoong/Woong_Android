package com.woong.woong_android.map.location_change

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.woong.woong_android.R

class LocationHistoryViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var history_address : TextView = itemView!!.findViewById(R.id.item_address_history_location) as TextView
}