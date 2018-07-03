package com.woong.woong_android.home.submenu

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.home.adapter.SubMenuPagerAdapter
import kotlinx.android.synthetic.main.fragment_submenu_tab.view.*

class SubMenu :android.support.v4.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_submenu_tab,container,false)
        val subMenuPagerAdapter = SubMenuPagerAdapter(this.childFragmentManager)
        val viewPager = v.viewpager_submenu
        val tabLayout = v.tab_top_submenu

        viewPager.adapter = subMenuPagerAdapter
        tabLayout.setTabTextColors(Color.parseColor("#b2b2b2"), Color.parseColor("#227958"))
        tabLayout.setupWithViewPager(viewPager)

        return v
    }
}