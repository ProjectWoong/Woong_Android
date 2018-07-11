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
import kotlinx.android.synthetic.main.fragment_home_grain.view.*

class HomeGrain : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_grain,container,false)

        v.relative_five_grain.setOnClickListener {
            TitleName.name = "오곡"
            TitleName.main_id = 2
            TitleName.sub_id = 1
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_minor_grain.setOnClickListener {
            TitleName.name = "잡곡"
            TitleName.main_id = 2
            TitleName.sub_id = 2
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_rice_grain.setOnClickListener {
            TitleName.name = "쌀"
            TitleName.main_id = 2
            TitleName.sub_id = 3
            (activity as MainActivity).replaceFragment(HomeProduct())
        }

        return v
    }
}