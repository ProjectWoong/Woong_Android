package com.woong.woong_android.seller_market.product

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R

class SellerMarketProductViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var productimg : ImageView = itemView!!.findViewById(R.id.item_productimg_sellermarket)
    var marketname : TextView = itemView!!.findViewById(R.id.item_marketname_sellermarket_product) as TextView
    var productname : TextView = itemView!!.findViewById(R.id.item_productname_sellermarket_product) as TextView
    var unitnum : TextView = itemView!!.findViewById(R.id.item_unitnum_sellermarket_product) as TextView
    var cost : TextView = itemView!!.findViewById(R.id.item_cost_sellermarket_product) as TextView
}