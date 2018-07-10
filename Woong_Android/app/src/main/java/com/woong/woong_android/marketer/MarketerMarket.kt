package com.woong.woong_android.marketer

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.marketer.adapter.MarketerPagerAdapter
import kotlinx.android.synthetic.main.fragment_market_intro.*
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

        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset<=-1*dpToPx(126.5f, act.applicationContext)) {
                act.supportActionBar?.show()
                v.toolbar_marketer.visibility=View.VISIBLE
                tabLayout.setBackgroundColor(Color.WHITE)
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#529C77"))
                tabLayout.setTabTextColors(Color.parseColor("#ADADAD"), Color.parseColor("#529C77"))
            } else {
                act.supportActionBar?.hide()
                v.toolbar_marketer.visibility=View.GONE
                tabLayout.setBackgroundColor(Color.parseColor("#529C77"))
                tabLayout.setSelectedTabIndicatorColor(Color.WHITE)
                tabLayout.setTabTextColors(Color.WHITE, Color.WHITE)
            }
        }
        v.appbar_marketer.addOnOffsetChangedListener(listener)

        v.tv_edit_marketer.setOnClickListener { // 수정하기 눌렀을 때
            // 마켓 이름 수정
            tv_edit_marketer.visibility = View.GONE
            tv_editcompl_marketer.visibility = View.VISIBLE
            tv_name_marketer.setTextColor(Color.parseColor("#9FDACE"))
            et_name_marketer.visibility = View.VISIBLE
            et_name_marketer.requestFocus()
            // 마켓 프로필 수정
            ib_editprof_marketer.visibility = View.VISIBLE
            // 마켓 인사말 수정
            tv_labelhi_marketintro.visibility = View.INVISIBLE
            tv_editlabelhi_marketintro.visibility = View.VISIBLE
            tv_hi_marketintro.visibility = View.GONE
            et_hi_marketintro.visibility = View.VISIBLE
            // 마켓 해시태그 수정
            linear_tags_marketintro.visibility = View.INVISIBLE
            linear_edittags_marketintro.visibility = View.VISIBLE
            // 마켓 대표사진 수정
            ib_editimg_marketintro.visibility = View.VISIBLE
        }
        v.tv_editcompl_marketer.setOnClickListener {    // 수정완료 눌렀을 때
            // 마켓 이름 수정
            tv_edit_marketer.visibility = View.VISIBLE
            tv_editcompl_marketer.visibility = View.GONE
            tv_name_marketer.setTextColor(Color.parseColor("#529C77"))
            et_name_marketer.visibility = View.GONE
            // 마켓 프로필 수정
            ib_editprof_marketer.visibility = View.GONE
            // 마켓 인사말 수정
            tv_labelhi_marketintro.visibility = View.VISIBLE
            tv_editlabelhi_marketintro.visibility = View.INVISIBLE
            tv_hi_marketintro.visibility = View.VISIBLE
            et_hi_marketintro.visibility = View.GONE
            // 마켓 해시태그 수정
            linear_tags_marketintro.visibility = View.VISIBLE
            linear_edittags_marketintro.visibility = View.INVISIBLE
            // 마켓 대표사진 수정
            ib_editimg_marketintro.visibility = View.GONE
        }

        return v
    }
    private fun dpToPx(dp:Float, context: Context):Float{
        return (dp * context.resources.displayMetrics.density)
    }
}