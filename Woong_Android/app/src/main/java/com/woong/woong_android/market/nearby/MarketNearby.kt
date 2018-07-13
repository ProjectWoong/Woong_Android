package com.woong.woong_android.market.nearby

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.market.adapter.MarketNearbyAdapter
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.SellerMarketActivity
import com.woong.woong_android.seller_market.get.GetNearMarketListResponse
import com.woong.woong_android.seller_market.get.GetNearMarketListResponseData
import com.woong.woong_android.woong_marketinfo
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_nearby_market.*
import kotlinx.android.synthetic.main.fragment_nearby_market.view.*



import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketNearby: Fragment(),View.OnClickListener {
    lateinit var marketNearbyAdapter: MarketNearbyAdapter
    lateinit var marketNearbyItems : ArrayList<GetNearMarketListResponseData>
    lateinit var networkService: NetworkService
    lateinit var requestManager: RequestManager

    override fun onClick(v: View?) {
        val intent = Intent(context, SellerMarketActivity::class.java)

        var idx : Int = this.rv_market_mymarket.getChildAdapterPosition(v)
        woong_marketinfo.market_id = marketNearbyItems[idx].market_id
        startActivity(intent)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_nearby_market,container,false)
        requestManager = Glide.with(this)
        networkService = ApplicationController.instance.networkService

        var user_token = woong_usertoken.user_token

        val getNearMarket = networkService.getNearMarketList(user_token)
        getNearMarket.enqueue(object : Callback<GetNearMarketListResponse>{
            override fun onFailure(call: Call<GetNearMarketListResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetNearMarketListResponse>?, response: Response<GetNearMarketListResponse>?) {
                if(response!!.isSuccessful){
                    marketNearbyItems = response.body().data
                    marketNearbyAdapter = MarketNearbyAdapter(marketNearbyItems,requestManager)
                    marketNearbyAdapter.setOnItemClickListener(this@MarketNearby)
                    v.rv_market_mymarket.layoutManager = LinearLayoutManager(context)
                    v.rv_market_mymarket.adapter = marketNearbyAdapter

                }
            }

        })


        return v
    }
}