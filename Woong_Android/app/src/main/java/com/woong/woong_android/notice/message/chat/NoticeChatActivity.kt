package com.woong.woong_android.notice.message.chat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.woong.woong_android.R
import com.woong.woong_android.notice.adapter.NtChatAdapter
import com.woong.woong_android.notice.data.ChatData
import kotlinx.android.synthetic.main.activity_notice_chat.*

class NoticeChatActivity : AppCompatActivity() {

    lateinit var chatItems : ArrayList<ChatData>
    lateinit var ntChatAdapter: NtChatAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_chat)

        chatItems = ArrayList()
        chatItems.add(ChatData(0,"안녕하세요"))
        chatItems.add(ChatData(1,"반가워용"))
        chatItems.add(ChatData(1,"감자얼마에여"))
        chatItems.add(ChatData(0,"안팔아여"))

        ntChatAdapter = NtChatAdapter(chatItems)
        rv_chat_notice.layoutManager = LinearLayoutManager(this)
        rv_chat_notice.adapter = ntChatAdapter



    }
}
