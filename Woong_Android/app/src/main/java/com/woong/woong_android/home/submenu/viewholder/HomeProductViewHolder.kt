package com.woong.woong_android.home.submenu.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R

class HomeProductViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {

    var productimg: ImageView = itemView!!.findViewById(R.id.iv_productimg_home) as ImageView
    var marketname: TextView = itemView!!.findViewById(R.id.marketname_bookmark_home) as TextView
    var productname: TextView = itemView!!.findViewById(R.id.productname_bookmark_home) as TextView
    var unitnum: TextView = itemView!!.findViewById(R.id.unitnum_bookmark_home) as TextView
    var unitname: TextView = itemView!!.findViewById(R.id.unitname_bookmark_home) as TextView
    var cost: TextView = itemView!!.findViewById(R.id.cost_bookmark_home) as TextView
    var firsttag: TextView = itemView!!.findViewById(R.id.firsttag_bookmark_home) as TextView
    var secondtag: TextView = itemView!!.findViewById(R.id.secondtag_bookmark_home) as TextView
    var favorite: ImageView = itemView!!.findViewById(R.id.btn_favorite_home) as ImageView
}