package com.woong.woong_android.seller_market.product

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.seller_market.get.GetSellerMarketProductResponseData

class SellerMarketProductAdapter(var productItems : ArrayList<GetSellerMarketProductResponseData>,var requestManager: RequestManager) : RecyclerView.Adapter<SellerMarketProductViewHolder>() {
    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener) {
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellerMarketProductViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_sellermarket_product, parent, false)
        mainView.setOnClickListener(onItemClick)
        return SellerMarketProductViewHolder(mainView)
    }

    override fun getItemCount(): Int = productItems.size

    override fun onBindViewHolder(holder: SellerMarketProductViewHolder, position: Int) {
        requestManager.load(productItems[position].file_key).into(holder.productimg)
        holder.marketname.text = productItems[position].market_name
        holder.productname.text =productItems[position].item_name
        holder.cost_per_unit.text = productItems[position].packaging
    }
}