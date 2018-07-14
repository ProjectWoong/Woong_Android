package com.woong.woong_android.notice.data

import android.widget.TextView

data class DeliveryData (
        var market_id : Int,
        var isShipping : Int,
        var product_img : Int,
        var market_name : String?,
        var product_name : String?,
        var order_date : String?,
        var order_cost : String?
)