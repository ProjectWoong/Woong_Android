package com.woong.woong_android.myproduct.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.bookmark.MyProductBookMark
import com.woong.woong_android.myproduct.cart.MyProductCart

class MpPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 ->  return MyProductBookMark()
            1 ->  return MyProductCart()

        }
        return MyProductBookMark()

    }

    override fun getCount(): Int {
        return 2 //페이지 개수 (내상품 - 찜한상품, 장바구니)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "찜한 상품"

            1 -> return "장바구니"
        }
        return null
    }


}