package com.woong.woong_android.seller_market.get

data class GetNearMarketListResponseData(
        var market_name : String?,
        var market_address : String?,
        var title_image_key : String?,
        var tag_name : String?,
        var youandi : String?,
        var market_id: Int
)