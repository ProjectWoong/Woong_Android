package com.woong.woong_android.seller_market.get

data class GetSellerMarketProductResponseData (
        var market_id : Int,
        var item_id : Int,
        var market_name : String?,
        var item_name : String?,
        var file_key : String?,
        var packaging : String?,
        var quick : Int,
        var delivery : Int

)