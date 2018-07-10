package com.woong.woong_android.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.home.submenu.data.HomeProductData
import com.woong.woong_android.home.submenu.viewholder.HomeProductViewHolder
import com.woong.woong_android.myproduct.data.MyProductBookmarkData
import com.woong.woong_android.myproduct.viewholder.MyProductBookmarkViewHolder

class HomeProductAdapter(private var productItems : ArrayList<HomeProductData>) : RecyclerView.Adapter<HomeProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_product_home,parent,false)
        return HomeProductViewHolder(view)
    }

    override fun getItemCount(): Int = productItems.size

    override fun onBindViewHolder(productViewHolder: HomeProductViewHolder, position: Int) {

        productViewHolder.productimg.setImageResource(productItems[position].pr_productimg)
        productViewHolder.marketname.text = productItems[position].pr_marketname
        productViewHolder.productname.text = productItems[position].pr_productname
        productViewHolder.unitname.text = productItems[position].pr_unitname
        productViewHolder.unitnum.text = productItems[position].pr_unitnum
        productViewHolder.cost.text = productItems[position].pr_cost
        productViewHolder.firsttag.text = productItems[position].pr_firsttag
        productViewHolder.secondtag.text = productItems[position].pr_secondtag
        if (productItems[position].pr_favorite){
            productViewHolder.favorite.setImageResource(R.drawable.consumer_allergy_onion)
        }else{
            productViewHolder.favorite.setImageResource(R.drawable.consumer_allergy_meal)
        }
    }
}