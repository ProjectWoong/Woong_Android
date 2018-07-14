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
        deliveryItems.add(DeliveryData(1,1,R.drawable.carrot,"알렉스마켓","당근","2018.07.14","9000원"))//1
        deliveryItems.add(DeliveryData(1,0,R.drawable.carrot,"알렉스마켓","당근","2018.07.02","12000원"))//1
        deliveryItems.add(DeliveryData(2,0,R.drawable.naenge,"혜원맥 농장","냉이","2018.07.04","9600원"))//2
        deliveryItems.add(DeliveryData(3,0,R.drawable.milk,"뚜덩마켓","갓 짜낸 우유","2018.07.06","24000원"))//3
        deliveryItems.add(DeliveryData(4,0,R.drawable.ggan,"그린푸드","깐마늘","2018.07.09","3400원"))//4
        deliveryItems.add(DeliveryData(5,0,R.drawable.bamgoguma,"영떠네 텃밭","밤고구마","2018.07.11","8900원"))//5
        deliveryItems.add(DeliveryData(6,0,R.drawable.peach,"브리트니네","복숭아","2018.07.13","14000원"))//6

        ing_shipping = ArrayList()
        done_shipping = ArrayList()

        for(i in 0 until deliveryItems.size){
            if(deliveryItems[i].isShipping >0){ //배송중
                var m_id = deliveryItems[i].market_id
                var ing = deliveryItems[i].isShipping
                var img=deliveryItems[i].product_img
                var market_name = deliveryItems[i].market_name
                var product_name = deliveryItems[i].product_name
                var order_date = deliveryItems[i].order_date
                var order_cost = deliveryItems[i].order_cost
                ing_shipping.add(DeliveryData(m_id,ing,img,market_name,product_name,order_date,order_cost))
            }
        }

        for(i in 0 until deliveryItems.size){
            if(deliveryItems[i].isShipping==0){ //배송완료
                var m_id = deliveryItems[i].market_id

                var done = deliveryItems[i].isShipping
                var img=deliveryItems[i].product_img
                var market_name = deliveryItems[i].market_name
                var product_name = deliveryItems[i].product_name
                var order_date = deliveryItems[i].order_date
                var order_cost = deliveryItems[i].order_cost
                done_shipping.add(DeliveryData(m_id,done,img,market_name,product_name,order_date,order_cost))
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