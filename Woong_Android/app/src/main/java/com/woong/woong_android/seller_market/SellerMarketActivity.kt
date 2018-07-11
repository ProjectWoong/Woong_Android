package com.woong.woong_android.seller_market

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.view.View
import com.woong.woong_android.R
import com.woong.woong_android.home.submenu.product.SellerIdx
import com.woong.woong_android.seller_market.adapter.SmPagerAdapter
import com.woong.woong_android.seller_market.product.SellerMarketProductDetail
import kotlinx.android.synthetic.main.activity_sellermarket.*



class SellerMarketActivity : AppCompatActivity() {

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.frame_sellermarket,fragment)
        transaction.addToBackStack(null)    // 이전 상태를 백스택에 추가하여 사용자가 백버튼을 눌렀을때에 대한 호환성 추가
        transaction.commit()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sellermarket)

        val myProductPagerAdapter = SmPagerAdapter(supportFragmentManager) // 프래그먼트안에 뷰페이저 쓸경우 childFragmentManager써주세욤
        val viewPager = viewpager_sellermarket
        val tabLayout = tab_top_sellermarket

        viewPager.adapter = myProductPagerAdapter
        viewPager.currentItem = SellerIdx.id
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"))
        tabLayout.setupWithViewPager(viewPager)
        if(SellerIdx.id==1){
            replaceFragment(SellerMarketProductDetail())
            SellerIdx.id=0
        }

        setSupportActionBar(toolbar)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.title_layout)
        supportActionBar?.setShowHideAnimationEnabled(false)

        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset<=-1*dpToPx(126.5f,applicationContext)) {
                toolbar.visibility=View.VISIBLE
                tab_top_sellermarket.setBackgroundColor(Color.WHITE)
                tab_top_sellermarket.setSelectedTabIndicatorColor(Color.parseColor("#529C77"))
                tab_top_sellermarket.setTabTextColors(Color.parseColor("#ADADAD"), Color.parseColor("#529C77"))
            } else {
                toolbar.visibility=View.INVISIBLE
                tab_top_sellermarket.setBackgroundColor(Color.parseColor("#529C77"))
                tab_top_sellermarket.setSelectedTabIndicatorColor(Color.WHITE)
                tab_top_sellermarket.setTabTextColors(Color.WHITE, Color.WHITE)
            }
        }
        appbar_sellermarket.addOnOffsetChangedListener(listener)
    }
    private fun dpToPx(dp:Float, context: Context):Float{
        return (dp * context.resources.displayMetrics.density)
    }
    fun getAcbar(): ActionBar? {
        return supportActionBar
    }
}
