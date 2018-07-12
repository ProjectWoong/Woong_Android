package com.woong.woong_android.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.home.submenu.get.GetItemResponseData
import com.woong.woong_android.home.submenu.viewholder.HomeProductViewHolder

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
        requestManager.load(productItems[position].file_key).into(productViewHolder.productimg)
        productViewHolder.marketname.text = productItems[position].market_name
        productViewHolder.productname.text = productItems[position].item_name
        productViewHolder.unitname.text = productItems[position].item_unit
        productViewHolder.cost.text = productItems[position].item_price.toString()
        if(productItems[position].quick==0)
            productViewHolder.firsttag.visibility = View.GONE
        if(productItems[position].delivery==0)
            productViewHolder.secondtag.visibility = View.GONE
        if (productItems[position].favorite_flag==1){
            productViewHolder.favorite.setImageResource(R.drawable.home_select_category_like1)
        }else{
            productViewHolder.favorite.setImageResource(R.drawable.home_select_category_no_like)
        }
    }
}