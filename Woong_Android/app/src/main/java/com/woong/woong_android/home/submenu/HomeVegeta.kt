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
import kotlinx.android.synthetic.main.fragment_home_vegeta.view.*

class HomeVegeta : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_vegeta,container,false)

        v.relative_potato_vegeta.setOnClickListener {
            TitleName.name = "감자"
            TitleName.main_id = 3
            TitleName.sub_id = 1
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_sweet_vegeta.setOnClickListener {
            TitleName.name = "고구마"
            TitleName.main_id = 3
            TitleName.sub_id = 2
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_pepper_vegeta.setOnClickListener {
            TitleName.name = "고추"
            TitleName.main_id = 3
            TitleName.sub_id = 3
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_herb_vegeta.setOnClickListener {
            TitleName.name = "나물"
            TitleName.main_id = 3
            TitleName.sub_id = 4
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_mushroom_vegeta.setOnClickListener {
            TitleName.name = "버섯"
            TitleName.main_id = 3
            TitleName.sub_id = 5
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_berry_vegeta.setOnClickListener {
            TitleName.name = "열매 채소"
            TitleName.main_id = 3
            TitleName.sub_id = 6
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_leaf_vegeta.setOnClickListener {
            TitleName.name = "잎 채소"
            TitleName.main_id = 3
            TitleName.sub_id = 7
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_root_vegeta.setOnClickListener {
            TitleName.name = "뿌리 채소"
            TitleName.main_id = 3
            TitleName.sub_id = 8
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        return v
    }
}