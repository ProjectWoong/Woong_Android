package com.woong.woong_android.market.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.woong.woong_android.market.bookmark.MarketBookmark
import com.woong.woong_android.market.nearby.MarketNearby
import com.woong.woong_android.myproduct.bookmark.MyProductBookMark
import com.woong.woong_android.myproduct.cart.MyProductCart

class MarketPagerAdpter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 ->  return MarketNearby()
            1 ->  return MarketBookmark()

        }
        return MarketNearby()

    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "내 주변 마켓"

            1 -> return "즐겨찾기"
        }
        return null
    }


}