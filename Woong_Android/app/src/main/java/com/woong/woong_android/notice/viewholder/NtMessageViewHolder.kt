package com.woong.woong_android.notice.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.woong.woong_android.R
import org.w3c.dom.Text

class NtMessageViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var alarm : TextView = itemView!!.findViewById(R.id.alarm_message_notice) as TextView
    var title : TextView = itemView!!.findViewById(R.id.title_message_notice) as TextView

}