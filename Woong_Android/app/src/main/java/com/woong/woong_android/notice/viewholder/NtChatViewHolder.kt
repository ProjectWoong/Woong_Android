package com.woong.woong_android.notice.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R

class NtChatViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {


    var msg : TextView = itemView!!.findViewById(R.id.msg_chat_notice) as TextView
    var seller_icon : ImageView = itemView!!.findViewById(R.id.icon_seller_chat) as ImageView



}