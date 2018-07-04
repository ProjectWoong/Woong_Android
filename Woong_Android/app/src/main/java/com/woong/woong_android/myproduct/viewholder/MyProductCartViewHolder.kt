package com.woong.woong_android.myproduct.viewholder

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.item_cart_myproduct.*
import org.w3c.dom.Text

class MyProductCartViewHolder(headerflag : Boolean,footerflag : Boolean,itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var headerflags = headerflag
    var footerflags = footerflag
    var all_selectflag = true
    lateinit var productimg :ImageView
    lateinit var marketname :TextView
    lateinit var productname :TextView
    lateinit var unitnum :TextView
    lateinit var unitname :TextView
    lateinit var cost :TextView
    lateinit var quantity :TextView
    lateinit var subtotal :TextView
    lateinit var checkbox : CheckBox

    lateinit var footer_totalproduct : TextView
    lateinit var footer_totalnum : TextView

    lateinit var header_checkbox : CheckBox

    init {
        if(!headerflags&&!footerflags){
            productimg  = itemView!!.findViewById(R.id.productimg_cart_myproduct) as ImageView
            marketname = itemView!!.findViewById(R.id.marketname_cart_myproduct) as TextView
            productname = itemView!!.findViewById(R.id.productname_cart_myproduct) as TextView
            unitnum = itemView!!.findViewById(R.id.unitnum_cart_myproduct) as TextView
            unitname = itemView!!.findViewById(R.id.unitname_cart_myproduct) as TextView
            cost = itemView!!.findViewById(R.id.cost_cart_myproduct) as TextView
            quantity = itemView!!.findViewById(R.id.quantity_cart_product) as TextView
            subtotal  = itemView!!.findViewById(R.id.subtotal_cart_myproduct) as TextView
            checkbox = itemView!!.findViewById(R.id.checkbox_cart_myproduct) as CheckBox
        }else if(!headerflags&&footerflags){ //푸터일때
            footer_totalproduct = itemView!!.findViewById(R.id.pdtotalnum_footer_myproduct) as TextView
            footer_totalnum = itemView!!.findViewById(R.id.totalnum_footer_myproduct) as TextView

        }else if(headerflags&&!footerflags){ //헤더일때
            header_checkbox = itemView!!.findViewById(R.id.all_checkbox_header_myproduct) as CheckBox
//            checkbox = itemView!!.findViewById(R.id.checkbox_cart_myproduct) as CheckBox
        }



    }


}