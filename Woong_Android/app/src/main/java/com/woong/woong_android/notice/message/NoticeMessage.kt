package com.woong.woong_android.notice.message

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.notice.adapter.NtMessageAdapter
import com.woong.woong_android.notice.data.MessageData
import com.woong.woong_android.notice.message.chat.NoticeChatActivity
import kotlinx.android.synthetic.main.fragment_notice_message.view.*

class NoticeMessage :Fragment(),View.OnClickListener {
    override fun onClick(p0: View?) {
        val intent : Intent = Intent(context,NoticeChatActivity::class.java)
        startActivity(intent)
    }

    lateinit var messageItems : ArrayList<MessageData>
    lateinit var ntMessageAdapter: NtMessageAdapter

    lateinit var newItems : ArrayList<MessageData>
    lateinit var oldItems : ArrayList<MessageData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_notice_message,container,false)

        messageItems = ArrayList()
        messageItems.add(MessageData(2))
        messageItems.add(MessageData(0))
        messageItems.add(MessageData(1))
        messageItems.add(MessageData(0))
        messageItems.add(MessageData(0))
        messageItems.add(MessageData(2))

        newItems = ArrayList()
        oldItems = ArrayList()

        for(i in 0 until messageItems.size){
            if(messageItems[i].alarm >0){ //new message data
               var new = messageItems[i].alarm
                newItems.add(MessageData(new))
            }
        }
        for(i in 0 until messageItems.size){
            if(messageItems[i].alarm ==0){ //old message data
                var old = messageItems[i].alarm
                oldItems.add(MessageData(old))
            }
        }
        ntMessageAdapter = NtMessageAdapter(newItems)
        ntMessageAdapter.setOnItemClickListener(this)
        v.rv_new_message.layoutManager = LinearLayoutManager(context)
        v.rv_new_message.adapter = ntMessageAdapter

        ntMessageAdapter = NtMessageAdapter(oldItems)
        ntMessageAdapter.setOnItemClickListener(this)
        v.rv_old_message.layoutManager = LinearLayoutManager(context)
         v.rv_old_message.adapter = ntMessageAdapter


        return v
    }
}