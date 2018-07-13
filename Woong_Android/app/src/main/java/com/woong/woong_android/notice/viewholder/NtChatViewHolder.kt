package com.woong.woong_android.notice.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.woong.woong_android.R

class NtChatViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {

    var time : TextView = itemView!!.findViewById(R.id.date_chat_notice) as TextView
    var msg : TextView = itemView!!.findViewById(R.id.msg_chat_notice) as TextView

}