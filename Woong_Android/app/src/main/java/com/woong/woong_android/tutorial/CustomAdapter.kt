package com.woong.woong_android.tutorial

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.slider.view.*
import kotlinx.android.synthetic.main.tutorial_item.view.*

class CustomAdapter (context: Context?)  : PagerAdapter() {

    val imageId = arrayOf(R.drawable.tutorial_1,R.drawable.tutorial_2,R.drawable.tutorial_3,R.drawable.tutorial_4)
    var context = context

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val v = LayoutInflater.from(context).inflate(R.layout.tutorial_item,container,false) //이런식으로 해서 따로 Layout
        v.tutorial_img.setImageResource(imageId[position])
        container.addView(v)
        return v
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imageId.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

}