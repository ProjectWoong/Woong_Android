package com.woong.woong_android.marketer

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.seller_market.adapter.SmPagerAdapter
import kotlinx.android.synthetic.main.activity_sellermarket.*

class MarketerMarket: Fragment() {
    @SuppressLint("RestrictedApi")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sellermarket_intro,container,false)
        val myProductPagerAdapter = SmPagerAdapter(childFragmentManager) // 프래그먼트안에 뷰페이저 쓸경우 childFragmentManager써주세욤
        val viewPager = viewpager_sellermarket
        val tabLayout = tab_top_sellermarket

        viewPager.adapter = myProductPagerAdapter
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"))
        tabLayout.setupWithViewPager(viewPager)

        MarketerMainActivity().setSupportActionBar(toolbar)

        MarketerMainActivity().supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        MarketerMainActivity().supportActionBar?.setDisplayShowCustomEnabled(true)
        MarketerMainActivity().supportActionBar?.setCustomView(R.layout.title_layout)
        MarketerMainActivity().supportActionBar?.setShowHideAnimationEnabled(false)

        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset<=-1*dpToPx(126.5f,MarketerMainActivity().applicationContext)) {
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
        test2.addOnOffsetChangedListener(listener)

        return v
    }
    private fun dpToPx(dp:Float, context: Context):Float{
        return (dp * context.resources.displayMetrics.density);
    }
}