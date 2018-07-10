package com.woong.woong_android.market.bookmark

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.adapter.MyProductBookmarkAdapter
import com.woong.woong_android.myproduct.data.MyProductBookmarkData
import kotlinx.android.synthetic.main.fragment_myproduct_bookmark.view.*

class MarketBookmark: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_bookmark_market,container,false)
        return v
    }
}