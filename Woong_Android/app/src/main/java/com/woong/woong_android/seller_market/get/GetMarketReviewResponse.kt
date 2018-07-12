package com.woong.woong_android.seller_market.get

data class GetMarketReviewResponse (
        var message : String?,
        var rate : RateMarketReviewData,
        var images : ArrayList<String?>,
        var reviews : ArrayList<GetMarketReviewResponseData>
)