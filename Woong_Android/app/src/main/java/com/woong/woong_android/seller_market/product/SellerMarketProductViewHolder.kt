package com.woong.woong_android.seller_market.product

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R

class SellerMarketProductViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var productimg : ImageView = itemView!!.findViewById(R.id.item_productimg_sellermarket) as ImageView
    var marketname : TextView = itemView!!.findViewById(R.id.item_marketname_sellermarket_product) as TextView
    var productname : TextView = itemView!!.findViewById(R.id.item_productname_sellermarket_product) as TextView
    var cost_per_unit : TextView = itemView!!.findViewById(R.id.cost_per_unit_sellermarket_product) as TextView
    var favorite : ImageView = itemView!!.findViewById(R.id.btn_bookmark_sellermarketproduct) as ImageView
}