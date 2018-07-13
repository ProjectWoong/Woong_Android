package com.woong.woong_android.myproduct

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.adapter.MpPagerAdapter
import kotlinx.android.synthetic.main.fragment_myproduct_tab.view.*

class MyProduct :android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_myproduct_tab,container,false)
        val myProductPagerAdapter = MpPagerAdapter(this.childFragmentManager) // 프래그먼트안에 뷰페이저 쓸경우 childFragmentManager써주세욤
        val viewPager = v.viewpager_myproduct
        val tabLayout = v.tab_top_myproduct

        viewPager.adapter = myProductPagerAdapter
        tabLayout.setTabTextColors(Color.parseColor("#b2b2b2"),Color.parseColor("#227958"))
        tabLayout.setupWithViewPager(viewPager)

        return v
    }
}