package com.woong.woong_android.marketer

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.woong.woong_android.R
import com.woong.woong_android.home.MyPage.MyPage
import com.woong.woong_android.home.main.HomeMain
import com.woong.woong_android.myproduct.MyProduct
import com.woong.woong_android.notice.Notice
import com.woong.woong_android.seller_market.SellerMarketActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_marketer_main.*

class MarketerMainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        when(p0){
            btn_market_marketer ->{
                replaceFragment(MarketerMarket())
            }
            btn_notice_marketer->{
                replaceFragment(Notice())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marketer_main)

        addFragment(MarketerMarket())

        btn_market_marketer.setOnClickListener(this)
        btn_notice_marketer.setOnClickListener(this)

    }

    fun addFragment(fragment: Fragment) {

        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.add(R.id.frame_fragment_marketer,fragment)
        transaction.commit()

    }

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.replace(R.id.frame_fragment_marketer,fragment)
        transaction.commit()
    }

}
