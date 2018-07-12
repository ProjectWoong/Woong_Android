package com.woong.woong_android.myproduct.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.bookmark.MyProductBookMark
import com.woong.woong_android.myproduct.get.GetFavoriteResponseData
import com.woong.woong_android.myproduct.viewholder.MyProductBookmarkViewHolder

class MyProductBookmarkAdapter(private var bookmarkItems : ArrayList<GetFavoriteResponseData>,var requestManager: RequestManager) : RecyclerView.Adapter<MyProductBookmarkViewHolder>() {

    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l: MyProductBookMark){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductBookmarkViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_bookmark_myproduct,parent,false)
        view.setOnClickListener(onItemClick)
        return MyProductBookmarkViewHolder(view)
    }

    override fun getItemCount(): Int = bookmarkItems.size

    override fun onBindViewHolder(bookmarkViewHolder: MyProductBookmarkViewHolder, position: Int) {
        requestManager.load(bookmarkItems[position].file_key).into(bookmarkViewHolder.productimg)
        bookmarkViewHolder.marketname.text = bookmarkItems[position].market_name
        bookmarkViewHolder.productname.text = bookmarkItems[position].item_name
        bookmarkViewHolder.unitname.text = bookmarkItems[position].item_unit
        bookmarkViewHolder.cost.text = bookmarkItems[position].item_price.toString()
        if(bookmarkItems[position].quick==0)
            bookmarkViewHolder.firsttag.visibility = View.GONE
        else
            bookmarkViewHolder.firsttag.visibility = View.VISIBLE

        if(bookmarkItems[position].delivery==0)
            bookmarkViewHolder.secondtag.visibility = View.GONE
        else
            bookmarkViewHolder.secondtag.visibility = View.VISIBLE
    }
}