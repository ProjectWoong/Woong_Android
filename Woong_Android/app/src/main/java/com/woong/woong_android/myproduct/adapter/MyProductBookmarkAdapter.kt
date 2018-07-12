package com.woong.woong_android.myproduct.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.home.post.PostFavoriteResponse
import com.woong.woong_android.myproduct.bookmark.MyProductBookMark
import com.woong.woong_android.myproduct.get.GetFavoriteResponseData
import com.woong.woong_android.myproduct.viewholder.MyProductBookmarkViewHolder
import com.woong.woong_android.woong_usertoken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        var networkService = ApplicationController.instance.networkService

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
        if (bookmarkItems[position].favorite_flag==1){
            bookmarkViewHolder.favorite.setImageResource(R.drawable.home_select_category_like1)
            bookmarkViewHolder.favorite.setOnClickListener {
                val delFavorite = networkService.delFavorite(woong_usertoken.user_token, bookmarkItems[position].item_id)
                delFavorite.enqueue(object : Callback<PostFavoriteResponse> {
                    override fun onFailure(call: Call<PostFavoriteResponse>?, t: Throwable?) {
                    }
                    override fun onResponse(call: Call<PostFavoriteResponse>?, response: Response<PostFavoriteResponse>?) {
                        if (response!!.isSuccessful) {
                            bookmarkViewHolder.favorite.setImageResource(R.drawable.home_select_category_no_like)
                        }
                    }
                })
            }
        }else{
            bookmarkViewHolder.favorite.setImageResource(R.drawable.home_select_category_no_like)
            bookmarkViewHolder.favorite.setOnClickListener {
                val postFavorite = networkService.postFavorite(woong_usertoken.user_token, bookmarkItems[position].item_id)
                postFavorite.enqueue(object : Callback<PostFavoriteResponse> {
                    override fun onFailure(call: Call<PostFavoriteResponse>?, t: Throwable?) {
                    }
                    override fun onResponse(call: Call<PostFavoriteResponse>?, response: Response<PostFavoriteResponse>?) {
                        if (response!!.isSuccessful) {
                            bookmarkViewHolder.favorite.setImageResource(R.drawable.home_select_category_like1)
                        }
                    }
                })
            }
        }
    }
}