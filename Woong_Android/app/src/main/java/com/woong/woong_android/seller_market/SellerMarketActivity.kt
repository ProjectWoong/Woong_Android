package com.woong.woong_android.seller_market

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.ActionBar
import android.util.Log
import com.woong.woong_android.R
import com.woong.woong_android.seller_market.adapter.SmPagerAdapter
import kotlinx.android.synthetic.main.activity_sellermarket.*

class SellerMarketActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sellermarket)

        val myProductPagerAdapter = SmPagerAdapter(supportFragmentManager) // 프래그먼트안에 뷰페이저 쓸경우 childFragmentManager써주세욤
        val viewPager = viewpager_sellermarket
        val tabLayout = tab_top_sellermarket

        viewPager.adapter = myProductPagerAdapter
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"))
        tabLayout.setupWithViewPager(viewPager)

        Log.d("scrollYYYYYY","11111111")
        setSupportActionBar(toolbar)
        scr.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            Log.d("scrollYYYYYY","22222222")
            Log.d("scrollYYYYYY",scrollY.toString())
        }
        supportActionBar?.setShowHideAnimationEnabled(true)

//        scr.viewTreeObserver.addOnScrollChangedListener {
////            scr.scrollY
//
//        }
//        if(scr.scrollY<=700)
//            supportActionBar?.setDisplayShowCustomEnabled(false)
        ActionBar.OnMenuVisibilityListener {
            supportActionBar?.setDisplayShowCustomEnabled(true)
            Log.d("scrollYYYYYY",scr.scrollY.toString())
        }

        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        supportActionBar?.setDisplayShowCustomEnabled(false)
        supportActionBar?.setCustomView(R.layout.title_layout)
    }
}
