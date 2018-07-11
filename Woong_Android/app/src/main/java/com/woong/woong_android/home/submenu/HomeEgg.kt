package com.woong.woong_android.home.submenu

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import com.woong.woong_android.home.submenu.product.HomeProduct
import kotlinx.android.synthetic.main.fragment_home_egg.view.*

class HomeEgg : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_egg,container,false)
        v.relative_egg_egg.setOnClickListener {
            TitleName.name = "달걀"
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        v.relative_milk_egg.setOnClickListener {
            TitleName.name = "우유"
            (activity as MainActivity).replaceFragment(HomeProduct())
        }
        return v
    }
}