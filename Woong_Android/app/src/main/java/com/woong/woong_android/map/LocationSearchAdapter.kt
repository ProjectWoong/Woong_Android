package com.woong.woong_android.map

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R

class LocationSearchAdapter(var locationsearchitems :ArrayList<LocationSearchItem> ) : RecyclerView.Adapter<LocationSearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationSearchViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_address_join_search, parent, false)
        return LocationSearchViewHolder(mainView)
    }

    override fun getItemCount(): Int = locationsearchitems.size

    override fun onBindViewHolder(holder: LocationSearchViewHolder, position: Int) {
        holder.address.text = locationsearchitems[position].address
        holder.road.text = locationsearchitems[position].road
    }
}