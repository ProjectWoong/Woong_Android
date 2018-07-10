package com.woong.woong_android.marketer

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.view.View
import com.woong.woong_android.R
import com.woong.woong_android.notice.Notice
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

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marketer_main)

        addFragment(MarketerMarket())

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.title_layout)
        supportActionBar?.setShowHideAnimationEnabled(false)

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
