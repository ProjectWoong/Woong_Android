package com.woong.woong_android.home.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.R.id.btn_favorite_home
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.home.get.GetItemResponseData
import com.woong.woong_android.home.post.PostFavoriteResponse
import com.woong.woong_android.home.viewholder.HomeProductViewHolder
import com.woong.woong_android.woong_usertoken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeProductAdapter(var productItems : ArrayList<GetItemResponseData>, var requestManager: RequestManager) : RecyclerView.Adapter<HomeProductViewHolder>() {

    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_home,parent,false)
        view.setOnClickListener(onItemClick)
        return HomeProductViewHolder(view)
    }

    override fun getItemCount(): Int = productItems.size

    override fun onBindViewHolder(productViewHolder: HomeProductViewHolder, position: Int) {
        var networkService = ApplicationController.instance.networkService

        requestManager.load(productItems[position].file_key).into(productViewHolder.productimg)
        productViewHolder.marketname.text = productItems[position].market_name
        productViewHolder.productname.text = productItems[position].item_name
        productViewHolder.unitname.text = productItems[position].item_unit
        productViewHolder.cost.text = productItems[position].item_price.toString()
        if(productItems[position].quick==0)
            productViewHolder.firsttag.visibility = View.GONE
        else
            productViewHolder.firsttag.visibility = View.VISIBLE

        if(productItems[position].delivery==0)
            productViewHolder.secondtag.visibility = View.GONE
        else
            productViewHolder.secondtag.visibility = View.VISIBLE
        if (productItems[position].favorite_flag==1){
            productViewHolder.favorite.setImageResource(R.drawable.home_select_category_like1)
            productViewHolder.favorite.setOnClickListener {
                val delFavorite = networkService.delFavorite(woong_usertoken.user_token, productItems[position].item_id)
                delFavorite.enqueue(object : Callback<PostFavoriteResponse> {
                    override fun onFailure(call: Call<PostFavoriteResponse>?, t: Throwable?) {
                    }
                    override fun onResponse(call: Call<PostFavoriteResponse>?, response: Response<PostFavoriteResponse>?) {
                        if (response!!.isSuccessful) {
                            productViewHolder.favorite.setImageResource(R.drawable.home_select_category_no_like)
                        }
                    }
                })
            }
        }else{
            productViewHolder.favorite.setImageResource(R.drawable.home_select_category_no_like)
            productViewHolder.favorite.setOnClickListener {
                val postFavorite = networkService.postFavorite(woong_usertoken.user_token, productItems[position].item_id)
                postFavorite.enqueue(object : Callback<PostFavoriteResponse> {
                    override fun onFailure(call: Call<PostFavoriteResponse>?, t: Throwable?) {
                    }
                    override fun onResponse(call: Call<PostFavoriteResponse>?, response: Response<PostFavoriteResponse>?) {
                        if (response!!.isSuccessful) {
                            productViewHolder.favorite.setImageResource(R.drawable.home_select_category_like1)
                        }
                    }
                })
            }
        }
    }
}