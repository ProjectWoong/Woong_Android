package com.woong.woong_android.notice.adapter

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.design.R.id.image
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.notice.data.ChatData
import com.woong.woong_android.notice.viewholder.NtChatViewHolder

class NtChatAdapter(private var chatItems : ArrayList<ChatData>) : RecyclerView.Adapter<NtChatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NtChatViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_seller_chat,parent,false)

        return NtChatViewHolder(v)
    }

    override fun getItemCount(): Int =chatItems.size

    override fun onBindViewHolder(holder: NtChatViewHolder, position: Int) {
        if(chatItems[position].chat_flag == 0){ //판매자
            holder.msg.text = chatItems[position].msg
            holder.seller_icon.visibility = View.VISIBLE
        }else if(chatItems[position].chat_flag == 1){ //소비자(me)
            holder.msg.text = chatItems[position].msg
            holder.msg.gravity = Gravity.RIGHT
            holder.msg.setBackgroundResource(R.drawable.consumer_message_img)
            holder.seller_icon.visibility = View.INVISIBLE
        }

    }
}