package com.woong.woong_android.market

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.market.adapter.MarketPagerAdpter
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_market_tab.view.*

class Market :android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_market_tab ,container,false)
        var user_token = arguments!!.getString("user_token")
        woong_usertoken.user_token = user_token
        val myProductPagerAdapter = MarketPagerAdpter(this.childFragmentManager) // 프래그먼트안에 뷰페이저 쓸경우 childFragmentManager써주세욤
        val viewPager = v.viewpager_market
        val tabLayout = v.tab_top_market

        viewPager.adapter = myProductPagerAdapter
        tabLayout.setTabTextColors(Color.parseColor("#adadad"), Color.parseColor("#227958"))
        tabLayout.setupWithViewPager(viewPager)

        return v
    }

}
