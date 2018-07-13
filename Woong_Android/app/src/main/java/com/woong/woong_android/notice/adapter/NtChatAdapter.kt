package com.woong.woong_android.notice.adapter

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.notice.get.ChatMessageListData
import com.woong.woong_android.notice.viewholder.NtChatViewHolder

class NtChatAdapter(private var chatItems : ArrayList<ChatMessageListData>) : RecyclerView.Adapter<NtChatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NtChatViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_notice,parent,false)

        return NtChatViewHolder(v)
    }

    override fun getItemCount(): Int =chatItems.size

    override fun onBindViewHolder(holder: NtChatViewHolder, position: Int) {
        if(chatItems[position].send_user == 1){ //판매자
            holder.msg.text = chatItems[position].content
           // holder.seller_icon.visibility = View.VISIBLE
        }else if(chatItems[position].send_user== 0){ //소비자
            holder.msg.text = chatItems[position].content
            holder.msg.gravity = Gravity.RIGHT
            holder.msg.setBackgroundResource(R.drawable.consumer_message_img)
           // holder.seller_icon.visibility = View.INVISIBLE
        }

    }
}