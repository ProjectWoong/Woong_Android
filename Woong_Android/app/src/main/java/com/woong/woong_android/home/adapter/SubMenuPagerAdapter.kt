package com.woong.woong_android.home.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.woong.woong_android.home.submenu.HomeEgg
import com.woong.woong_android.home.submenu.HomeFruit
import com.woong.woong_android.home.submenu.HomeGrain
import com.woong.woong_android.home.submenu.HomeVegeta


class SubMenuPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return HomeFruit()
            1 -> return HomeGrain()
            2 -> return HomeVegeta()
            3 -> return HomeEgg()
        }
        return null
    }

    override fun getCount(): Int {
        return 4 //페이지 개수 (홈(서브메뉴) - 과일, 곡물 ,,,)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "과일"
            1 -> return "곡물"
            2 -> return "채소"
            3 -> return "달걀/유제품"
        }
        return null
    }
}