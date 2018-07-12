package com.woong.woong_android.myproduct.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.get.GetCartResponseData
import com.woong.woong_android.myproduct.viewholder.MyProductCartViewHolder

class MyProductCartAdapter(private var cartItems : ArrayList<GetCartResponseData>,var requestManager: RequestManager) : RecyclerView.Adapter<MyProductCartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductCartViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_cart_myproduct,parent,false)
        return MyProductCartViewHolder(mainView)
    }

    override fun getItemCount(): Int = cartItems.size
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: MyProductCartViewHolder, position: Int) {
        requestManager.load(cartItems[position].file_key).into(holder.productimg)
        holder.marketname.text = cartItems[position].carttitle
        holder.cost.text = cartItems[position].packging
        holder.delivery.text = cartItems[position].delivery.toString()+"원"
        holder.del.setOnClickListener {
            TODO()
        }
//        holder.header_checkbox.setOnClickListener {
//            if(holder.header_checkbox.isChecked){
//                holder.header_checkbox.isChecked = false
//               holder.checkbox.isChecked = false
//            }else{
//                holder.header_checkbox.isChecked = true
//                holder.checkbox.isChecked = true
//            }
//        }
    }
}