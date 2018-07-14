package com.woong.woong_android.seller_market.product

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.home.post.PostFavoriteResponse
import com.woong.woong_android.seller_market.get.GetFavoriteFlagResponse
import com.woong.woong_android.seller_market.get.GetSellerMarketProductResponseData
import com.woong.woong_android.woong_usertoken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class SellerMarketProductAdapter(var productItems: ArrayList<GetSellerMarketProductResponseData>, var requestManager: RequestManager) : RecyclerView.Adapter<SellerMarketProductViewHolder>() {
    private lateinit var onItemClick: View.OnClickListener
    var favoriteFlags: ArrayList<Int> = ArrayList()
    fun setOnItemClickListener(l: View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellerMarketProductViewHolder {
        val mainView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_sellermarket_product, parent, false)
        mainView.setOnClickListener(onItemClick)
        for (i in 1..itemCount) {
            favoriteFlags.add(0)
        }
        return SellerMarketProductViewHolder(mainView)
    }

    override fun getItemCount(): Int = productItems.size

    override fun onBindViewHolder(holder: SellerMarketProductViewHolder, position: Int) {
        var networkService = ApplicationController.instance.networkService

        val getFavoriteFlag = networkService.getFavoriteFlag(woong_usertoken.user_token, productItems[position].item_id)
        getFavoriteFlag.enqueue(object : Callback<GetFavoriteFlagResponse> {
            override fun onFailure(call: Call<GetFavoriteFlagResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetFavoriteFlagResponse>?, response: Response<GetFavoriteFlagResponse>?) {
                if (response!!.isSuccessful) {
                    favoriteFlags[position] = response!!.body().message.toInt()
                    Log.d("ASDa", favoriteFlags[position].toString())
                }
            }
        })
        requestManager.load(productItems[position].file_key).apply {
            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
        }.into(holder.productimg)
        holder.marketname.text = productItems[position].market_name
        holder.productname.text = productItems[position].item_name
        holder.cost_per_unit.text = productItems[position].packaging

        Log.d("ASDb", favoriteFlags[position].toString())
        if (favoriteFlags[position] == 1) {
            Log.d("ASDc", "ASD")
            holder.favorite.setImageResource(R.drawable.home_select_category_like1)
            holder.favorite.setOnClickListener {
                Log.d("asd", "aaaaaaa")
                val delFavorite = networkService.delFavorite(woong_usertoken.user_token, productItems[position].item_id)
                delFavorite.enqueue(object : Callback<PostFavoriteResponse> {
                    override fun onFailure(call: Call<PostFavoriteResponse>?, t: Throwable?) {
                        Log.d("asd", t.toString())
                    }

                    override fun onResponse(call: Call<PostFavoriteResponse>?, response: Response<PostFavoriteResponse>?) {
                        if (response!!.isSuccessful) {
                            Log.d("asd", "asdasd")
                            holder.favorite.setImageResource(R.drawable.home_select_category_no_like)
                            favoriteFlags[position] = 0
                            notifyItemRangeChanged(position, itemCount)
                        }
                    }
                })
            }
        } else {
            Log.d("ASDd", "ASD")
            holder.favorite.setImageResource(R.drawable.home_select_category_no_like)
            holder.favorite.setOnClickListener {
                val postFavorite = networkService.postFavorite(woong_usertoken.user_token, productItems[position].item_id)
                postFavorite.enqueue(object : Callback<PostFavoriteResponse> {
                    override fun onFailure(call: Call<PostFavoriteResponse>?, t: Throwable?) {
                    }

                    override fun onResponse(call: Call<PostFavoriteResponse>?, response: Response<PostFavoriteResponse>?) {
                        if (response!!.isSuccessful) {
                            holder.favorite.setImageResource(R.drawable.home_select_category_like1)
                            favoriteFlags[position] = 1
                            notifyItemRangeChanged(position, itemCount)
                        }
                    }
                })
            }
        }

    }
}
}