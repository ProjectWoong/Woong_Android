package com.woong.woong_android.seller_market.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.woong.woong_android.myproduct.bookmark.MyProductBookMark
import com.woong.woong_android.myproduct.cart.MyProductCart
import com.woong.woong_android.seller_market.album.SellerMarketAlbum
import com.woong.woong_android.seller_market.intro.SellerMarketIntro
import com.woong.woong_android.seller_market.product.SellerMarketProduct
import com.woong.woong_android.seller_market.review.SellerMarketReview

class SmPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
//            0 -> return SellerMarketIntro()
            1 -> return SellerMarketProduct()
            0 ->  return MyProductBookMark()
//            1 ->  return MyProductCart()
            2 -> return SellerMarketAlbum()
            3 -> return SellerMarketReview()
        }
        return SellerMarketIntro()
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "소개"
            1 -> return "물품"
            2 -> return "앨범"
            3 -> return "후기"
        }
        return null
    }
}