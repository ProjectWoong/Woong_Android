package com.woong.woong_android.market.nearby

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.market.adapter.MarketNearbyAdapter
import com.woong.woong_android.market.data.MarketNearbyData
import kotlinx.android.synthetic.main.fragment_nearby_market.view.*

class MarketNearby: Fragment() {
    lateinit var marketNearbyAdapter: MarketNearbyAdapter
    lateinit var marketNearbyItems : ArrayList<MarketNearbyData>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_nearby_market,container,false)
        marketNearbyItems = ArrayList()

        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농",null))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농","#유기농"))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농",null))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농","#유기농"))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농",null))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농","#유기농"))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농",null))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농","#유기농"))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농",null))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농","#유기농"))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농",null))
        marketNearbyItems.add(MarketNearbyData(R.drawable.ic_launcher_background,"현듀마켓","마포구 우리집","#유기농","#유기농","#유기농"))

        marketNearbyAdapter = MarketNearbyAdapter(marketNearbyItems)

        v.rv_market_mymarket.layoutManager = LinearLayoutManager(context)
        v.rv_market_mymarket.adapter = marketNearbyAdapter

        return v
    }
}