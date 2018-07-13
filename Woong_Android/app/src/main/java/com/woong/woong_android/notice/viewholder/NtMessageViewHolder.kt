package com.woong.woong_android.notice.viewholder

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.woong.woong_android.R
import org.w3c.dom.Text

class NtMessageViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView) {
    var alarm : TextView = itemView!!.findViewById(R.id.alarm_message_notice) as TextView
    var title : TextView = itemView!!.findViewById(R.id.title_message_notice) as TextView
    var img : ImageView = itemView!!.findViewById(R.id.profileimg_message_notice) as ImageView
    var time : TextView = itemView!!.findViewById(R.id.time_message_notice) as TextView
    var recentmsg : TextView = itemView!!.findViewById(R.id.recentmsg_message_notice) as TextView
    var bgr :LinearLayout = itemView!!.findViewById(R.id.bgr_message_notice) as LinearLayout

}