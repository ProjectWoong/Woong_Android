package com.woong.woong_android.home.main

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.woong.woong_android.*
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.home.product.HomeProduct
import com.woong.woong_android.map.get.GetLocationResponse
import com.woong.woong_android.map.location_change.LocationSearchChangeActivity
import com.woong.woong_android.market.Market
import com.woong.woong_android.market.bookmark.MarketBookmark
import com.woong.woong_android.myproduct.MyProduct
import com.woong.woong_android.myproduct.bookmark.MyProductBookMark
import com.woong.woong_android.myproduct.cart.MyProductCart
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.notice.Notice
import com.woong.woong_android.thisweek.ThisWeek
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home_main.view.*
import kotlinx.android.synthetic.main.fragment_product_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeMain : Fragment() {
    lateinit var imm : InputMethodManager
    var flag :Int? = 0
    var re_address : String = ""
    lateinit var networkService: NetworkService
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_main,container,false)

        networkService = ApplicationController.instance.networkService
        val usertoken = woong_usertoken.user_token
        val getLocation = networkService.getLocation(usertoken)
        getLocation.enqueue(object : Callback<GetLocationResponse>{
            override fun onFailure(call: Call<GetLocationResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetLocationResponse>?, response: Response<GetLocationResponse>?) {
                if(response!!.isSuccessful){
                    v.tv_location_main.text = response.body().data.real_address
                    location.simple_address = response.body().data.real_address!!

                }
            }

        })
        flag = arguments?.getInt("flag")
        Log.v("flag",flag.toString())
        if(flag == 1){
            Log.v("플래그값",flag.toString())
//            re_address = arguments!!.getString("re_address")
//            Log.v("주소진짜받음",re_address)
            v.tv_location_main.text = location.simple_address
        }

        v.iv_thisweek_main.setOnClickListener {
                val fm = activity!!.supportFragmentManager
                val transaction = fm.beginTransaction()
                transaction.replace(R.id.frame_fragment_main, ThisWeek())
                transaction.addToBackStack(null)
                transaction.commit()
        }



        // 메인 메뉴 4가지 클릭리스너
        v.relative_fruit_main.setOnClickListener {
            Idx.idx = 0
            (activity as MainActivity).replaceFragment(com.woong.woong_android.home.submenu.SubMenu())
        }
        v.relative_grain_main.setOnClickListener {
            Idx.idx = 1
            (activity as MainActivity).replaceFragment(com.woong.woong_android.home.submenu.SubMenu())
        }
        v.relative_vegeta_main.setOnClickListener {
            Idx.idx = 2
            (activity as MainActivity).replaceFragment(com.woong.woong_android.home.submenu.SubMenu())
        }
        v.relative_egg_main.setOnClickListener {
            Idx.idx = 3
            (activity as MainActivity).replaceFragment(com.woong.woong_android.home.submenu.SubMenu())
        }

        v.tv_location_main.setOnClickListener {
            val intent = Intent(context,LocationSearchChangeActivity::class.java)
            startActivity(intent)
            activity!!.overridePendingTransition( R.anim.slide_in_down, R.anim.slide_stay_down)
        }

        v.tv_search_main.setOnEditorActionListener { textView, i, keyEvent ->
            when(i){
                EditorInfo.IME_ACTION_SEARCH->{
                    searchString.flag = true
                    searchString.str = textView.text.toString()
                    (activity as MainActivity).replaceFragment(HomeProduct())
                    imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager //키보드 내리기위해서
                    imm.hideSoftInputFromWindow(textView.windowToken, 0)
                    true
                }
            }
            false
        }
        v.relative_deliver_main.setOnClickListener {
            frgIntent.flag=1
            frgIntent.idx=1
            (activity as MainActivity).replaceFragment(Notice())
            (activity as MainActivity).clearSelected()
            (activity as MainActivity).btn_notice_main.isSelected = true
        }
        v.relative_favorite_main.setOnClickListener {
            (activity as MainActivity).replaceFragment(MyProduct())
            (activity as MainActivity).clearSelected()
            (activity as MainActivity).btn_myproduct_main.isSelected = true
        }
        v.relative_bookmark_main.setOnClickListener{
            frgIntent.flag=1
            frgIntent.idx=1
            (activity as MainActivity).replaceFragment(Market())
            (activity as MainActivity).clearSelected()
            (activity as MainActivity).btn_market_main.isSelected = true
        }
        v.relative_msg_main.setOnClickListener {
            (activity as MainActivity).replaceFragment(Notice())
            (activity as MainActivity).clearSelected()
            (activity as MainActivity).btn_notice_main.isSelected = true
        }
        return v
    }
}
object Idx{
    var idx : Int = 0
}