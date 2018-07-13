package com.woong.woong_android.notice.deliveryandreview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.notice.adapter.NtDelivertandReviewAdapter
import com.woong.woong_android.notice.data.DeliveryData
import kotlinx.android.synthetic.main.fragment_notice_delireview.view.*

class NoticeDeliveryAndReview :Fragment() {
    lateinit var deliveryItems : ArrayList<DeliveryData>
    lateinit var ntDelivertandReviewAdapter: NtDelivertandReviewAdapter
    lateinit var ing_shipping : ArrayList<DeliveryData>
    lateinit var done_shipping : ArrayList<DeliveryData>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_notice_delireview,container,false)
        deliveryItems = ArrayList()
        deliveryItems.add(DeliveryData(1))
        deliveryItems.add(DeliveryData(0))
        deliveryItems.add(DeliveryData(0))
        deliveryItems.add(DeliveryData(0))
        deliveryItems.add(DeliveryData(0))
        deliveryItems.add(DeliveryData(0))

        ing_shipping = ArrayList()
        done_shipping = ArrayList()

        for(i in 0 until deliveryItems.size){
            if(deliveryItems[i].isShipping >0){ //배송중
                var ing = deliveryItems[i].isShipping
                ing_shipping.add(DeliveryData(ing))
            }
        }

        for(i in 0 until deliveryItems.size){
            if(deliveryItems[i].isShipping==0){ //배송완료
                var done = deliveryItems[i].isShipping
                done_shipping.add(DeliveryData(done))
            }
        }

        ntDelivertandReviewAdapter = NtDelivertandReviewAdapter(context!!,ing_shipping)
        v.rv_ing_deliver.layoutManager = LinearLayoutManager(context)
        v.rv_ing_deliver.adapter = ntDelivertandReviewAdapter

        ntDelivertandReviewAdapter = NtDelivertandReviewAdapter(context!!,done_shipping)
        v.rv_done_deliver.layoutManager = LinearLayoutManager(context)
        v.rv_done_deliver.adapter = ntDelivertandReviewAdapter

        return v
    }
}