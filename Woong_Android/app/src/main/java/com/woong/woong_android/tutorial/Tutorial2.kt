package com.woong.woong_android.tutorial

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.fragment_tutorial2.view.*

class Tutorial2 : Fragment() {
    val bundle = Bundle()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_tutorial2, container, false)
        v.btn_next_tutorial2.setOnClickListener{
            replaceFragment(Tutorial3())
        }
        return v
    }
    fun replaceFragment(fragment: Fragment) {
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.frame_tutorial,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}