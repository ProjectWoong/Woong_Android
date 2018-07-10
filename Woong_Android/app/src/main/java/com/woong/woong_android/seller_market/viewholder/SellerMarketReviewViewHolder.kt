package com.woong.woong_android.seller_market.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.item_sellermarket_review.view.*
import org.w3c.dom.Text

class SellerMarketReviewViewHolder(itemView: View?):RecyclerView.ViewHolder(itemView) {
    var review_name : TextView = itemView!!.findViewById(R.id.name_review_sellermarket) as TextView
    var review : TextView = itemView!!.findViewById(R.id.review_sellermarket) as TextView
}