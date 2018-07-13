package com.woong.woong_android.seller_market.get

data class GetMarketReviewResponse (
        var message : String?,
        var rate : RateMarketReviewData,
        var images : ArrayList<ImagesMarketReviewData>,
        var reviews : ArrayList<GetMarketReviewResponseData>
)