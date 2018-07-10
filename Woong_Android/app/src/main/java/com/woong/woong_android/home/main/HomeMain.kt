package com.woong.woong_android.home.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import com.woong.woong_android.home.adapter.SubMenuPagerAdapter
import com.woong.woong_android.map.location_change.LocationSearchChangeActivity
import com.woong.woong_android.marketer.MarketerMainActivity
import kotlinx.android.synthetic.main.fragment_home_main.*
import kotlinx.android.synthetic.main.fragment_home_main.view.*
import kotlinx.android.synthetic.main.fragment_submenu_tab.*
import kotlinx.android.synthetic.main.fragment_submenu_tab.view.*

class HomeMain : Fragment() {
    var flag :Int? = 0
    var re_address : String = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_main,container,false)
        flag = arguments?.getInt("flag")
        Log.v("flag",flag.toString())
        if(flag == 1){
            Log.v("플래그값",flag.toString())
            re_address = arguments!!.getString("re_address")
            Log.v("주소진짜받음",re_address)
            v.tv_location_main.text = re_address
        }
        // 메인 메뉴 4가지 클릭리스너
        v.relative_fruit_main.setOnClickListener {
            (activity as MainActivity).replaceFragment(com.woong.woong_android.home.submenu.SubMenu())
        }
        v.relative_grain_main.setOnClickListener {
            (activity as MainActivity).replaceFragment(com.woong.woong_android.home.submenu.SubMenu())
            com.woong.woong_android.home.submenu.SubMenu()
            val tmp = inflater.inflate(R.layout.fragment_submenu_tab,container,false)
            val viewPager = tmp.viewpager_submenu
            viewPager.adapter = SubMenuPagerAdapter(this.childFragmentManager)
//            tmp.viewpager_submenu.setCurrentItem(3, true)
            viewPager.currentItem = 2
        }
        v.relative_vegeta_main.setOnClickListener {
            (activity as MainActivity).replaceFragment(com.woong.woong_android.home.submenu.SubMenu())
        }
        v.relative_egg_main.setOnClickListener {
            (activity as MainActivity).replaceFragment(com.woong.woong_android.home.submenu.SubMenu())
        }

        v.tv_location_main.setOnClickListener {
            val intent = Intent(context,LocationSearchChangeActivity::class.java)
            startActivity(intent)
        }

        return v
    }


}