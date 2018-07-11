package com.woong.woong_android.home.submenu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import com.woong.woong_android.TitleName
import com.woong.woong_android.home.submenu.product.HomeProduct
import kotlinx.android.synthetic.main.fragment_home_fruit.view.*

class HomeFruit : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_fruit,container,false)
        v.relative_banana_fruit.setOnClickListener {
            TitleName.name = "바나나"
            TitleName.main_id = 1
            TitleName.sub_id = 1
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_peach_fruit.setOnClickListener {
            TitleName.name = "복숭아"
            TitleName.main_id = 1
            TitleName.sub_id = 2
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_apple_fruit.setOnClickListener {
            TitleName.name = "사과"
            TitleName.main_id = 1
            TitleName.sub_id = 3
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_orange_fruit.setOnClickListener {
            TitleName.name = "오렌지"
            TitleName.main_id = 1
            TitleName.sub_id = 4
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_straw_fruit.setOnClickListener {
            TitleName.name = "딸기"
            TitleName.main_id = 1
            TitleName.sub_id = 5
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        return v
    }
}