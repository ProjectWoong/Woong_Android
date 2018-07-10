package com.woong.woong_android.marketer

import android.annotation.SuppressLint
import android.content.Context
import android.drm.DrmStore
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.marketer.adapter.MarketerPagerAdapter
import kotlinx.android.synthetic.main.fragment_marketer_top.*
import kotlinx.android.synthetic.main.fragment_marketer_top.view.*

class MarketerMarket: Fragment() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("RestrictedApi", "WrongConstant")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_marketer_top,container,false)
        val myProductPagerAdapter = MarketerPagerAdapter(this.childFragmentManager) // 프래그먼트안에 뷰페이저 쓸경우 childFragmentManager써주세욤
        val viewPager = v.viewpager_marketer
        val tabLayout = v.tab_top_marketer
        val act = (activity as MarketerMainActivity)

        viewPager.adapter = myProductPagerAdapter
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"))
        tabLayout.setupWithViewPager(viewPager)

        act.supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        act.supportActionBar?.setDisplayShowCustomEnabled(true)
        act.supportActionBar?.setCustomView(R.layout.title_layout)
        act.supportActionBar?.setShowHideAnimationEnabled(false)

        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset<=-1*dpToPx(126.5f, act.applicationContext)) {
                v.toolbar_marketer.visibility=View.VISIBLE
                tabLayout.setBackgroundColor(Color.WHITE)
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#529C77"))
                tabLayout.setTabTextColors(Color.parseColor("#ADADAD"), Color.parseColor("#529C77"))
            } else {
                v.toolbar_marketer.visibility=View.INVISIBLE
                tabLayout.setBackgroundColor(Color.parseColor("#529C77"))
                tabLayout.setSelectedTabIndicatorColor(Color.WHITE)
                tabLayout.setTabTextColors(Color.WHITE, Color.WHITE)
            }
        }
        v.appbar_marketer.addOnOffsetChangedListener(listener)

        return v
    }
    private fun dpToPx(dp:Float, context: Context):Float{
        return (dp * context.resources.displayMetrics.density)
    }
}