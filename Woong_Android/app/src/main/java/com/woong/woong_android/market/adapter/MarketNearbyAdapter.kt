package com.woong.woong_android.market.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.market.viewholder.MarketNearbyViewHolder
import com.woong.woong_android.seller_market.get.GetBookmarkFlagResponse
import com.woong.woong_android.seller_market.get.GetNearMarketListResponseData
import com.woong.woong_android.woong_usertoken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketNearbyAdapter(private var nearbyItems : ArrayList<GetNearMarketListResponseData>,var requestManager: RequestManager) : RecyclerView.Adapter<MarketNearbyViewHolder>() {

    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketNearbyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_market_mymarket,parent,false)
        view.setOnClickListener(onItemClick)
        return MarketNearbyViewHolder(view)
    }

    override fun getItemCount(): Int = nearbyItems.size

    override fun onBindViewHolder(nearbyViewHolder: MarketNearbyViewHolder, position: Int) {
        val networkService = ApplicationController.instance.networkService

        requestManager.load(nearbyItems[position].title_image_key).apply {
            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
        }.into(nearbyViewHolder.img)
        nearbyViewHolder.name.text = nearbyItems[position].market_name
        nearbyViewHolder.address.text = nearbyItems[position].market_address

        var getBookmarkFlag = networkService.getBookmarkFlag(woong_usertoken.user_token, nearbyItems[position].market_id)
        getBookmarkFlag.enqueue(object : Callback<GetBookmarkFlagResponse> {
            override fun onFailure(call: Call<GetBookmarkFlagResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetBookmarkFlagResponse>?, response: Response<GetBookmarkFlagResponse>?) {
                if (response!!.isSuccessful){
                    if(response.body().message=="1") {  // 즐찾 중이라면 찬 별 표시
                        nearbyViewHolder.label.setImageResource(R.drawable.market_lanking_favorite)
                    }
                }
            }
        })

        var tag : List<String> =nearbyItems[position].tag_name!!.split(",")

        nearbyViewHolder.tag1.text = "#"+tag[0]
        nearbyViewHolder.tag2.text = "#"+tag[1]
    }
}