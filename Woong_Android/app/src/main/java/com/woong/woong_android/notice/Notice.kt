package com.woong.woong_android.notice

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.frgIntent
import com.woong.woong_android.myproduct.adapter.MpPagerAdapter
import com.woong.woong_android.notice.adapter.NtPagerAdapter
import kotlinx.android.synthetic.main.fragment_myproduct_tab.view.*
import kotlinx.android.synthetic.main.fragment_notice_tab.view.*

class Notice : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_notice_tab,container,false)
        val ntPagerAdapter = NtPagerAdapter(this.childFragmentManager) // 프래그먼트안에 뷰페이저 쓸경우 childFragmentManager써주세욤
        val viewPager = v.viewpager_notice
        val tabLayout = v.tab_top_notice

        if (frgIntent.flag==1){
            viewPager.currentItem = frgIntent.idx
            frgIntent.flag = 0
        }

        viewPager.adapter = ntPagerAdapter
        tabLayout.setTabTextColors(Color.parseColor("#b2b2b2"), Color.parseColor("#227958"))
        tabLayout.setupWithViewPager(viewPager)


        return v
    }
}