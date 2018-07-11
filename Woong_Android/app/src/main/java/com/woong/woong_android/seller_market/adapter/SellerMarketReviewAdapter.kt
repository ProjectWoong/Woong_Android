package com.woong.woong_android.seller_market.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.seller_market.get.GetMarketReviewResponseData
import com.woong.woong_android.seller_market.review.data.SellerMarketReviewData
import com.woong.woong_android.seller_market.viewholder.SellerMarketReviewViewHolder

class SellerMarketReviewAdapter(private var reviewItems:ArrayList<GetMarketReviewResponseData>,var flag : Int):RecyclerView.Adapter<SellerMarketReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellerMarketReviewViewHolder {
       val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_sellermarket_review,parent,false)
        return SellerMarketReviewViewHolder(mainView)
    }

    override fun getItemCount(): Int {
        if(flag == 1){
             return reviewItems.size
        }else {
            return 3
        }

    }
    override fun onBindViewHolder(holder: SellerMarketReviewViewHolder, position: Int) {
        holder.review_name.text = reviewItems[position].user_id.toString()
        holder.review.text = reviewItems[position].content

    }
}