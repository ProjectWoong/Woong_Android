package com.woong.woong_android.notice.message.chat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.chat
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.notice.adapter.NtChatAdapter
import com.woong.woong_android.notice.get.ChatMessageListData
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.activity_notice_chat.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeChatActivity : AppCompatActivity() {

    lateinit var chatItems : ArrayList<ChatMessageListData>
    lateinit var ntChatAdapter: NtChatAdapter
    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_chat)

        networkService = ApplicationController.instance.networkService
        val usertoken = woong_usertoken.user_token
        val chat_room_id = chat.chat_room_num

        val getChatMessage = networkService.getChatMessage(usertoken,chat_room_id)

        getChatMessage.enqueue(object : Callback<ChatMessageListData>{
            override fun onFailure(call: Call<ChatMessageListData>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<ChatMessageListData>?, response: Response<ChatMessageListData>?) {
                if(response!!.isSuccessful){
                    ntChatAdapter = NtChatAdapter(chatItems)
                    rv_chat_notice.layoutManager = LinearLayoutManager(this@NoticeChatActivity)
                    rv_chat_notice.adapter = ntChatAdapter
                }
            }

        })

//        chatItems = ArrayList()
//        chatItems.add(ChatData(0,"안녕하세요"))
//        chatItems.add(ChatData(1,"반가워용"))
//        chatItems.add(ChatData(1,"감자얼마에여"))
//        chatItems.add(ChatData(0,"안팔아여"))
//
//        networkService = ApplicationController.instance.networkService
//        var usertoken = woong_usertoken.user_token
//        val getChatMessage = networkService.getChatMessage()
//
//        ntChatAdapter = NtChatAdapter(chatItems)
//        rv_chat_notice.layoutManager = LinearLayoutManager(this)
//        rv_chat_notice.adapter = ntChatAdapter



    }
}