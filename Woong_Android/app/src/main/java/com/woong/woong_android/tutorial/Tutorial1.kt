package com.woong.woong_android.tutorial

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.fragment_tutorial1.view.*

class Tutorial1 : Fragment() {
    lateinit var viewPager: ViewPager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_tutorial1, container, false)

        val adapter = CustomAdapter(context)

        viewPager = v.findViewById(R.id.viewpager_tutorial)
        viewPager.adapter = adapter //()이런식으로 안하고 요로케 하넹

        return v
    }

}