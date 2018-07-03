package com.woong.woong_android.myproduct.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.data.MyProductBookmarkData
import com.woong.woong_android.myproduct.viewholder.MyProductBookmarkViewHolder

class MyProductBookmarkAdapter(private var bookmarkItems : ArrayList<MyProductBookmarkData>) : RecyclerView.Adapter<MyProductBookmarkViewHolder>() {
    var headerFlags = false;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductBookmarkViewHolder {
        val mainView : View
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_bookmark_myproduct,parent,false)
//        if(viewType == 0) {
//            headerFlags = true
//            mainView = LayoutInflater.from(parent.context).inflate(R.layout.header_cart_myproduct,parent,false)
//            return MyProductBookmarkViewHolder(mainView)
//        }
//
        return MyProductBookmarkViewHolder(view)
    }

    override fun getItemCount(): Int = bookmarkItems.size

    override fun onBindViewHolder(bookmarkViewHolder: MyProductBookmarkViewHolder, position: Int) {

        bookmarkViewHolder.productimg.setImageResource(bookmarkItems[position].bm_productimg)
        bookmarkViewHolder.marketname.text = bookmarkItems[position].bm_marketname
        bookmarkViewHolder.productname.text = bookmarkItems[position].bm_productname
        bookmarkViewHolder.unitname.text = bookmarkItems[position].bm_unitname
        bookmarkViewHolder.unitnum.text = bookmarkItems[position].bm_unitnum
        bookmarkViewHolder.cost.text = bookmarkItems[position].bm_cost
        bookmarkViewHolder.firsttag.text = bookmarkItems[position].bm_firsttag
        bookmarkViewHolder.secondtag.text = bookmarkItems[position].bm_secondtag
    }
}