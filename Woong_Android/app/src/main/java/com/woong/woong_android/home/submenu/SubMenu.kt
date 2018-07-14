package com.woong.woong_android.home.submenu

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.R.id.container
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.home.adapter.SubMenuPagerAdapter
import com.woong.woong_android.home.main.Idx
import com.woong.woong_android.location
import com.woong.woong_android.map.get.GetLocationResponse
import com.woong.woong_android.map.location_change.LocationSearchChangeActivity
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.submain
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_home_main.view.*
import kotlinx.android.synthetic.main.fragment_submenu_tab.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubMenu :android.support.v4.app.Fragment() {
    lateinit var networkService:NetworkService
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_submenu_tab,container,false)
        val subMenuPagerAdapter = SubMenuPagerAdapter(this.childFragmentManager)
        val viewPager = v.viewpager_submenu
        val tabLayout = v.tab_top_submenu

        networkService = ApplicationController.instance.networkService
        val usertoken = woong_usertoken.user_token
        val getLocation = networkService.getLocation(usertoken)
        getLocation.enqueue(object : Callback<GetLocationResponse> {
            override fun onFailure(call: Call<GetLocationResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetLocationResponse>?, response: Response<GetLocationResponse>?) {
                if(response!!.isSuccessful){
                    v.tv_location_submenu.text = response.body().data.real_address
                    location.simple_address = response.body().data.real_address!!

                }
            }

        })

        v.tv_location_submenu.setOnClickListener {
            val intent = Intent(context,LocationSearchChangeActivity::class.java)
            submain.flag =1
            startActivity(intent)
        }
        if(submain.right==1){
            v.tv_location_submenu.text = location.simple_address
        }

        viewPager.adapter = subMenuPagerAdapter
        viewPager.currentItem = Idx.idx
        Idx.idx=0
        tabLayout.setTabTextColors(Color.parseColor("#b2b2b2"), Color.parseColor("#227958"))
        tabLayout.setupWithViewPager(viewPager)

        return v
    }
}