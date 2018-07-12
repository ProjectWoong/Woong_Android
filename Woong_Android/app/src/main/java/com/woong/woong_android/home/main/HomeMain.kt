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
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import com.woong.woong_android.home.submenu.product.HomeProduct
import com.woong.woong_android.map.location_change.LocationSearchChangeActivity
import com.woong.woong_android.searchString
import kotlinx.android.synthetic.main.fragment_home_main.view.*
import kotlinx.android.synthetic.main.fragment_product_home.*

class HomeMain : Fragment() {
    lateinit var imm : InputMethodManager
    var flag :Int? = 0
    var re_address : String = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_main,container,false)

        flag = arguments?.getInt("flag")
        Log.v("flag",flag.toString())
        if(flag == 1){
            Log.v("플래그값",flag.toString())
            re_address = arguments!!.getString("re_address")
            Log.v("주소진짜받음",re_address)
            v.tv_location_main.text = re_address
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
        return v
    }
}
object Idx{
    var idx : Int = 0
}