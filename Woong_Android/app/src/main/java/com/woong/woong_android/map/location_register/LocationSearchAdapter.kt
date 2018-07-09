package com.woong.woong_android.map.location_register

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.map.get.GetLocationListResponse
import com.woong.woong_android.map.get.GetLocationListResponseData
import retrofit2.Callback

class LocationSearchAdapter(var locationsearchitems :ArrayList<GetLocationListResponseData> ) : RecyclerView.Adapter<LocationSearchViewHolder>() {
    private  lateinit var onItemClick : View.OnClickListener
    fun setOnItemClickListener(l: View.OnClickListener){
        onItemClick =l
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationSearchViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_address_join_search, parent, false)
        mainView.setOnClickListener(onItemClick)
        return LocationSearchViewHolder(mainView)
    }

    override fun getItemCount(): Int = locationsearchitems.size

    override fun onBindViewHolder(holder: LocationSearchViewHolder, position: Int) {
        holder.address.text = locationsearchitems[position].place_name //지번주소를 장소이름으로 대체
        holder.road.text = locationsearchitems[position].road_address_name
    }
}