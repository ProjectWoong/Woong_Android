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
    var headerFlags = false
    var footerFlags = false
    var all_selectflag = true
    var state = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductCartViewHolder {
        var mainView : View
        if(viewType == 0) { //헤더일때
            headerFlags = true
            footerFlags = false
            mainView = LayoutInflater.from(parent.context).inflate(R.layout.header_cart_myproduct,parent,false)


        }else if (viewType == cartItems.size+1){ //푸터일때
            headerFlags = false
            footerFlags = true
            mainView = LayoutInflater.from(parent.context).inflate(R.layout.footer_cart_myproduct,parent,false)
        }else{
            headerFlags = false
            footerFlags = false
            mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_cart_myproduct,parent,false)
        }

        return MyProductCartViewHolder(headerFlags,footerFlags,mainView)
    }

    override fun getItemCount(): Int = cartItems.size + 2
    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onBindViewHolder(holder: MyProductCartViewHolder, position: Int) {

        if(holder.headerflags&&!holder.footerflags){ //헤더

            holder.header_checkbox.isChecked = true
            holder.header_checkbox.setOnClickListener {
                if(holder.header_checkbox.isChecked){
                    state = 0
                    holder.header_checkbox.isChecked = false
                    all_selectflag = false
                    //holder.checkbox.isChecked = false
                }else{
                    state = 1
                    holder.header_checkbox.isChecked = true
                    all_selectflag = true
                    //holder.checkbox.isChecked = true
                }

            }


        }else if(!holder.headerflags&&holder.footerflags){ //푸터

        }else {
            holder.productimg.setImageResource(cartItems[position-1].c_productimg)
            holder.marketname.text = cartItems[position-1].c_marketname
            holder.productname.text = cartItems[position-1].c_productname
            holder.unitname.text = cartItems[position-1].c_unitname
            holder.unitnum.text = cartItems[position-1].c_unitnum
            holder.cost.text = cartItems[position-1].c_cost
            holder.subtotal.text = cartItems[position-1].c_subtotal
            holder.quantity.text = cartItems[position-1].c_quantity
           // cartItems.get(position-1)



        }



    }
    fun isAllChecked():Boolean{
        return all_selectflag
    }

}