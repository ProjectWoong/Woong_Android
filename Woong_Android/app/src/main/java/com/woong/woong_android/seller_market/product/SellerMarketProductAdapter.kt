package com.woong.woong_android.seller_market.product

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R

class SellerMarketProductAdapter(var productItems : ArrayList<SellerMarketProductItem>) : RecyclerView.Adapter<SellerMarketProductViewHolder>() {
    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellerMarketProductViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_sellermarket_product, parent, false)
        return SellerMarketProductViewHolder(mainView)
    }

    override fun getItemCount(): Int = productItems.size

    override fun onBindViewHolder(holder: SellerMarketProductViewHolder, position: Int) {
        holder.productimg.setImageResource(productItems[position].productimg)
        holder.marketname.text = productItems[position].marketname
        holder.productname.text = productItems[position].productname
        holder.unitnum.text = productItems[position].unitnum
        holder.cost.text = productItems[position].cost
    }
}