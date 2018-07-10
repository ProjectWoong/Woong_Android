package com.woong.woong_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.SubMenu
import android.view.View
import com.woong.woong_android.my.MyPage
import com.woong.woong_android.home.main.HomeMain
import com.woong.woong_android.market.Market
import com.woong.woong_android.myproduct.MyProduct
import com.woong.woong_android.notice.Notice
import com.woong.woong_android.seller_market.SellerMarketActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home_main.*
import kotlinx.android.synthetic.main.fragment_home_main.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val bundle = Bundle()
    override fun onClick(p0: View?) {
        when(p0){
            btn_home_main ->{
                clearSelected()
                btn_home_main.isSelected = true
                replaceFragment(HomeMain())
                // 판매자 마켓 테스트용 임시 인텐트
//                val intent = Intent(applicationContext, SellerMarketActivity::class.java)
//                startActivity(intent)
            }
            btn_market_main ->{
                clearSelected()
                btn_market_main.isSelected = true
                replaceFragment(Market())
            }
            btn_myproduct_main ->{
                clearSelected()
                btn_myproduct_main.isSelected = true
                replaceFragment(MyProduct())
            }
            btn_notice_main->{
                clearSelected()
                btn_notice_main.isSelected = true
                replaceFragment(Notice())
            }
            btn_my_main ->{
                clearSelected()
                btn_my_main.isSelected = true
                replaceFragment(MyPage())
            }
        }
    }
   var flag : Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flag = intent.getIntExtra("address_flag",0)
        if(flag == 1){
            var re_address = intent.getStringExtra("search_address")
            Log.v("주소넘김",re_address)
            bundle.putString("re_address",re_address)
            bundle.putInt("flag",1)
            HomeMain().arguments = bundle
        }
        addFragment(HomeMain())

        btn_home_main.isSelected = true
        btn_myproduct_main.setOnClickListener(this)
        btn_home_main.setOnClickListener(this)
        btn_market_main.setOnClickListener(this)
        btn_my_main.setOnClickListener(this)
        btn_notice_main.setOnClickListener(this)

    }

    fun addFragment(fragment: Fragment) {

        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.add(R.id.frame_fragment_main,fragment)
        transaction.commit()

    }

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.replace(R.id.frame_fragment_main,fragment)
        transaction.commit()
    }

    fun clearSelected(){
        btn_myproduct_main.isSelected = false
        btn_home_main.isSelected = false
        btn_market_main.isSelected = false
        btn_my_main.isSelected = false
        btn_notice_main.isSelected = false
    }

}
