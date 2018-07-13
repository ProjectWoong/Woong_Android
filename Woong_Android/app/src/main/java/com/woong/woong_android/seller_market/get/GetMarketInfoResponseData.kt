package com.woong.woong_android.seller_market.get

data class GetMarketInfoResponseData (
        var market_id : Int,
        var market_name:String?,
        var tag_name:String?,
        var delivery: Int,
        var quick:Int,
        var bookmark_count:Int,
        var title_image_key:String?,
        var farmer_image_key:String?,
        var market_info:String?,
        var youandi :String?
)