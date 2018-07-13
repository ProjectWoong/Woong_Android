package com.woong.woong_android.tutorial

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_tutorial4.view.*

class Tutorial4 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_tutorial4, container, false)
        v.btn_start_tutorial4.setOnClickListener {
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
            activity!!.finish()
        }
        return v
    }
}