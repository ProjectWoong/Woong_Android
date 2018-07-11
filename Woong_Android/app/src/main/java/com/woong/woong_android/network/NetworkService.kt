package com.woong.woong_android.network

import com.woong.woong_android.map.get.GetLocationListResponse
import com.woong.woong_android.seller_market.get.*
import com.woong.woong_android.Login.post.PostSignInAppResponse
import com.woong.woong_android.Login.post.PostSignInAppResponseData
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    //주소를 키워드로 검색시 연관 주소 목록들 가져오기 (손대지 마세요!!)
    @GET("v2/local/search/keyword.json")
    fun getLocationList(@Header("Authorization") header: String,
                        @Query("query") query: String): Call<GetLocationListResponse>


    //////////////////////// //주석과 함께 메소드(GET,POST 등등)적어주세요////////////////////////////////////////////


    //////////////////////마켓소개페이지 부분//////////////////////////////////////////////////////////////
    @GET("market/info/{market_id}") //마켓 첫 페이지
    fun getMarketDetail(@Header("usertoken") user: String,
                        @Path("market_id") idx: Int): Call<GetMarketInfoResponse>

    @GET("/market/{market_id}") //해당 마켓의 물품목록 보기 (name정렬, best정렬)
    fun getMarketProductList(@Path("market_id") idx: Int,
                             @Query("option") option: String): Call<GetSellerMarketProductResponse>

    @GET("/market/{market_id}/item/{item_id}") //그 물품을 눌렀을때 물품상세페이지 보기
    fun getProductDetail(@Path("market_id") market_id: Int,
                         @Path("item_id") item_id: Int): Call<GetProductDetailResponse>

    @GET("/market/{market_id}/album") //마켓의 앨범보기
    fun getMarketAlbum(@Path("market_id") market_id: Int): Call<GetMarketAlbumResponse>

    @GET("/market/{market_id}/review") //마켓의 후기보기
    fun getMarketReview(@Path("market_id") market_id: Int): Call<GetMarketReviewResponse>

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @GET("/market/distance")//하단탭<마켓> - 내주변마켓리스트 보기
    fun getNearMarketList(@Header("usertoken")user_token:String?) : Call<GetNearMarketListResponse>



    ////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @POST("/account/signin/app") //로그인하기
    fun postMarketSignInApp(@Body signin : PostSignInAppResponseData):Call<PostSignInAppResponse>

}