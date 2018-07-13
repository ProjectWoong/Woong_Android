package com.woong.woong_android.home.adapter

import android.content.res.Resources
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.home.viewholder.MarketBookmarkViewHolder
import com.woong.woong_android.market.get.GetBookmarkResponseData

class MarketBookmarkAdapter(var bookmarkItems : ArrayList<GetBookmarkResponseData>, var requestManager: RequestManager) : RecyclerView.Adapter<MarketBookmarkViewHolder>() {

    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketBookmarkViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_bookmark_mymarket,parent,false)
        view.setOnClickListener(onItemClick)
        return MarketBookmarkViewHolder(view)
    }

    override fun getItemCount(): Int = bookmarkItems.size

    override fun onBindViewHolder(ViewHolder: MarketBookmarkViewHolder, position: Int) {
        var networkService = ApplicationController.instance.networkService

        requestManager.load(bookmarkItems[position].title_image_key).into(ViewHolder.marketimg)
        ViewHolder.marketname.text = bookmarkItems[position].market_name
        ViewHolder.address.text = bookmarkItems[position].market_address
//        ViewHolder.bookmark.setOnClickListener {
//            // 상태(버튼의 이미지)에 따라 북마크 해제/설정(Del/Post)
//            Log.d("asd", (ViewHolder.bookmark.drawable).toString())
////            Log.d("asd", (Resources.getSystem().getDrawable(R.drawable.tab_market_favorite)).toString())
//            Log.d("asd", (ContextCompat.getDrawable(ViewHolder.marketimg.context,R.drawable.tab_market_favorite)).toString())
//
//
////            if (ViewHolder.bookmark.drawable == ContextCompat.getDrawable(ViewHolder.marketimg.context,R.drawable.tab_market_favorite)) {
//
//            if (ViewHolder.bookmark.drawable == ContextCompat.getDrawable(ViewHolder.marketimg.context,R.drawable.tab_market_favorite)) {
//                ViewHolder.bookmark.setImageResource(R.drawable.market_favorite_favorite_o)
//            } else {
//                ViewHolder.bookmark.setImageResource(R.drawable.tab_market_favorite)
//            }
//        }
    }
}