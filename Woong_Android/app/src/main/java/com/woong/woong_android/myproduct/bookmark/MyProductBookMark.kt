package com.woong.woong_android.myproduct.bookmark

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R

class MyProductBookMark : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val v = inflater.inflate(R.layout.fragment_myproduct_bookmark,container,false)
        return v
    }
}