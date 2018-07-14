package com.woong.woong_android.home.adapter

import android.content.res.Resources
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.home.viewholder.MarketBookmarkViewHolder
import com.woong.woong_android.market.get.GetBookmarkResponseData
import com.woong.woong_android.seller_market.post.PostBookmarkResponse
import com.woong.woong_android.woong_marketinfo
import com.woong.woong_android.woong_usertoken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketBookmarkAdapter(var bookmarkItems : ArrayList<GetBookmarkResponseData>, var requestManager: RequestManager) : RecyclerView.Adapter<MarketBookmarkViewHolder>() {

    private lateinit var onItemClick : View.OnClickListener
    var bookmarkFlag:Int = 1
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

        requestManager.load(bookmarkItems[position].title_image_key).apply {
            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
        }.into(ViewHolder.marketimg)
        ViewHolder.marketname.text = bookmarkItems[position].market_name
        ViewHolder.address.text = bookmarkItems[position].market_address
        ViewHolder.bookmark.setOnClickListener {
//            // 상태(버튼의 이미지)에 따라 북마크 해제/설정(Del/Post)
            var postBookmark : Call<PostBookmarkResponse>

            if(bookmarkFlag==1){ // 즐찾 중이라면
                postBookmark = networkService.delBookmark(woong_usertoken.user_token, bookmarkItems[position].market_id)
                postBookmark.enqueue(object : Callback<PostBookmarkResponse> {
                    override fun onFailure(call: Call<PostBookmarkResponse>?, t: Throwable?) {
                    }

                    override fun onResponse(call: Call<PostBookmarkResponse>?, response: Response<PostBookmarkResponse>?) {
                        ViewHolder.bookmark.setImageResource(R.drawable.market_favorite_x_cancel)
                        bookmarkFlag=0
                        Toast.makeText(ViewHolder.marketimg.context, "즐겨찾기에서 해제되었습니다", Toast.LENGTH_SHORT).show()
                    }
                })
            }else{
                postBookmark = networkService.postBookmark(woong_usertoken.user_token, woong_marketinfo.market_id)
                postBookmark.enqueue(object : Callback<PostBookmarkResponse> {
                    override fun onFailure(call: Call<PostBookmarkResponse>?, t: Throwable?) {
                    }

                    override fun onResponse(call: Call<PostBookmarkResponse>?, response: Response<PostBookmarkResponse>?) {
                        ViewHolder.bookmark.setImageResource(R.drawable.market_favorite_favorite_o)
                        bookmarkFlag=1
                    }
                })
            }
        }
    }
}