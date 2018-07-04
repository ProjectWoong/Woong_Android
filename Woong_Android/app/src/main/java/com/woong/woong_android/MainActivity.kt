package com.woong.woong_android

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Base64
import android.util.Log
import android.view.SubMenu
import android.view.View
import com.woong.woong_android.R
import com.woong.woong_android.R.id.*
import com.woong.woong_android.home.MyPage.MyPage
import com.woong.woong_android.home.main.HomeMain
import com.woong.woong_android.myproduct.MyProduct
import com.woong.woong_android.notice.Notice
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        when(p0){
            btn_home_main ->{
                replaceFragment(HomeMain())
            }
            btn_market_main ->{
                replaceFragment(com.woong.woong_android.home.submenu.SubMenu())
            }
            btn_myproduct_main ->{
                replaceFragment(MyProduct())
            }
            btn_notice_main->{
                replaceFragment(Notice())
            }
            btn_my_main ->{
                replaceFragment(MyPage())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(HomeMain())

        btn_myproduct_main.setOnClickListener(this)
        btn_home_main.setOnClickListener(this)
        btn_market_main.setOnClickListener(this)
        btn_my_main.setOnClickListener(this)
        btn_notice_main.setOnClickListener(this)

    }

    fun addFragment(fragment: Fragment) {

        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.add(R.id.frame_fragment_main,fragment)
        transaction.commit()

    }

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.replace(R.id.frame_fragment_main,fragment)
        transaction.commit()
    }

}
