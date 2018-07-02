package com.woong.woong_android.myproduct

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.adapter.MpPagerAdapter
import kotlinx.android.synthetic.main.fragment_myproduct_tab.view.*

class MyProduct :android.support.v4.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_myproduct_tab,container,false)
        val myProductPagerAdapter = MpPagerAdapter(activity!!.supportFragmentManager)
        val viewPager = v.viewpager_myproduct
        val tabLayout = v.tab_top_myproduct

        viewPager.adapter = myProductPagerAdapter
        tabLayout.setTabTextColors(Color.parseColor("#b2b2b2"),Color.parseColor("#227958"))
        tabLayout.setupWithViewPager(viewPager)

        return v
    }
}