package com.woong.woong_android.notice.adapter

import android.app.FragmentManager
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.woong.woong_android.myproduct.bookmark.MyProductBookMark
import com.woong.woong_android.myproduct.cart.MyProductCart
import com.woong.woong_android.notice.deliveryandreview.NoticeDeliveryAndReview
import com.woong.woong_android.notice.message.NoticeMessage

class NtPagerAdapter(fm:android.support.v4.app.FragmentManager):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 ->  return NoticeMessage()
            1 ->  return NoticeDeliveryAndReview()
        }
        return null

    }

    override fun getCount(): Int {
        return 2 //페이지 개수 (알림 - 메시지, 배송/상세후기)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "메시지"

            1 -> return "배송/상세후기"
        }
        return null
    }
}