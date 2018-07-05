package com.woong.woong_android.myproduct.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.data.MyProductCartData
import com.woong.woong_android.myproduct.viewholder.MyProductCartViewHolder

class MyProductCartAdapter(private var cartItems : ArrayList<MyProductCartData>) : RecyclerView.Adapter<MyProductCartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductCartViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_cart_myproduct,parent,false)

        return MyProductCartViewHolder(mainView)
    }

    override fun getItemCount(): Int = cartItems.size
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: MyProductCartViewHolder, position: Int) {

        holder.productimg.setImageResource(cartItems[position].c_productimg)
        holder.marketname.text = cartItems[position].c_marketname
        holder.productname.text = cartItems[position].c_productname
        holder.unitname.text = cartItems[position].c_unitname
        holder.unitnum.text = cartItems[position].c_unitnum
        holder.cost.text = cartItems[position].c_cost
        holder.subtotal.text = cartItems[position].c_subtotal
        holder.quantity.text = cartItems[position].c_quantity
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