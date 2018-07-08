package com.woong.woong_android.home.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.map.location_change.LocationSearchChangeActivity
import kotlinx.android.synthetic.main.fragment_home_main.*
import kotlinx.android.synthetic.main.fragment_home_main.view.*

class HomeMain : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_main,container,false)
        var re_address:String? = arguments!!.getString("re_address")

        tv_location_main?.text = re_address
        v.tv_location_main.setOnClickListener {
            val intent = Intent(context,LocationSearchChangeActivity::class.java)
            startActivity(intent)
        }

        return v
    }


}