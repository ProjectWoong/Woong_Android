package com.woong.woong_android.market

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.location
import com.woong.woong_android.map.get.GetLocationResponse
import com.woong.woong_android.map.location_change.LocationSearchChangeActivit
import com.woong.woong_android.frgIntent
import com.woong.woong_android.market.adapter.MarketPagerAdpter
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.submain
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_market_tab.view.*
import kotlinx.android.synthetic.main.fragment_submenu_tab.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Market :android.support.v4.app.Fragment() {
    lateinit var networkService : NetworkService
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_market_tab ,container,false)
        var user_token = arguments!!.getString("user_token")

        woong_usertoken.user_token = user_token

        val myProductPagerAdapter = MarketPagerAdpter(this.childFragmentManager) // 프래그먼트안에 뷰페이저 쓸경우 childFragmentManager써주세욤
        val viewPager = v.viewpager_market
        val tabLayout = v.tab_top_market

        networkService = ApplicationController.instance.networkService
        val usertoken = woong_usertoken.user_token
        val getLocation = networkService.getLocation(usertoken)
        getLocation.enqueue(object : Callback<GetLocationResponse> {
            override fun onFailure(call: Call<GetLocationResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetLocationResponse>?, response: Response<GetLocationResponse>?) {
                if(response!!.isSuccessful){
                    v.tv_logo_market.text = response.body().data.real_address
                    location.simple_address = response.body().data.real_address!!

                }
            }

        })

        v.tv_logo_market.setOnClickListener {
            val intent = Intent(context, LocationSearchChangeActivity::class.java)
            submain.flag =2
            startActivity(intent)
        }
        if(submain.right==2){
            v.tv_logo_market.text = location.simple_address
        }

        viewPager.adapter = myProductPagerAdapter
        if(frgIntent.flag==1){
            viewPager.currentItem = frgIntent.idx
            frgIntent.flag=0
        }
        tabLayout.setTabTextColors(Color.parseColor("#adadad"), Color.parseColor("#227958"))
        tabLayout.setupWithViewPager(viewPager)

        return v
    }

}
