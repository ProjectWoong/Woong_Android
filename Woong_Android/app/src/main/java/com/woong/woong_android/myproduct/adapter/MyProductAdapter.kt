package com.woong.woong_android.myproduct.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.data.MyProductBookmarkData
import com.woong.woong_android.myproduct.viewholder.MyProductViewHolder
import kotlinx.android.synthetic.main.fragment_myproduct_bookmark.view.*

class MyProductAdapter(private var bookmarkItems : ArrayList<MyProductBookmarkData>) : RecyclerView.Adapter<MyProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_bookmark_myproduct,parent,false)
        return MyProductViewHolder(view)
    }

    override fun getItemCount(): Int = bookmarkItems.size

    override fun onBindViewHolder(holder: MyProductViewHolder, position: Int) {

        holder.productimg.setImageResource(bookmarkItems[position].productimg)
        holder.marketname.text = bookmarkItems[position].marketname
        holder.productname.text = bookmarkItems[position].productname
        holder.unitname.text = bookmarkItems[position].unitname
        holder.unitnum.text = bookmarkItems[position].unitnum
        holder.cost.text = bookmarkItems[position].cost
        holder.firsttag.text = bookmarkItems[position].firsttag
        holder.secondtag.text = bookmarkItems[position].secondtag
    }
}