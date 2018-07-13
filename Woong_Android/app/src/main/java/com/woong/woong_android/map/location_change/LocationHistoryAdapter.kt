package com.woong.woong_android.map.location_change

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.map.get.HistoryOfLoactionData

class LocationHistoryAdapter(private var historyItems : ArrayList<HistoryOfLoactionData>):RecyclerView.Adapter<LocationHistoryViewHolder>() {
    private lateinit var onItemClick: View.OnClickListener
    fun setOnItemClickListner(I : View.OnClickListener){
        onItemClick = I
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationHistoryViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_history_address,parent,false)
        mainView.setOnClickListener(onItemClick)
        return LocationHistoryViewHolder(mainView)
    }

    override fun getItemCount(): Int =historyItems.size
    override fun onBindViewHolder(holder: LocationHistoryViewHolder, position: Int) {
        holder.history_address.text = historyItems[position].history_name
    }
}