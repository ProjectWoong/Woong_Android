package com.woong.woong_android.network

import com.woong.woong_android.join.consumer.post.PostSignUpResponse
import com.woong.woong_android.join.consumer.post.PostSignUpResponseData
import com.woong.woong_android.map.get.GetLocationListResponse
import com.woong.woong_android.seller_market.get.*
import com.woong.woong_android.login.post.PostSignInAppResponse
import com.woong.woong_android.login.post.PostSignInAppResponseData
import com.woong.woong_android.myproduct.get.GetFavoriteResponse
import com.woong.woong_android.home.get.GetSearchItemResponse
import com.woong.woong_android.home.get.GetSubItemResponse
import com.woong.woong_android.home.post.PostFavoriteResponse
<<<<<<< HEAD
import com.woong.woong_android.map.get.GetLocationResponse
import com.woong.woong_android.map.put.PutLocationRegisterResponse
import com.woong.woong_android.map.put.PutLocationRegisterResponseData
import com.woong.woong_android.market.get.GetBookmarkResponse
import com.woong.woong_android.myproduct.get.GetCartResponse
import com.woong.woong_android.myproduct.post.PostCartResponse
import com.woong.woong_android.notice.get.ChatMessageListData
import com.woong.woong_android.notice.get.GetChatMessageResponseData
import com.woong.woong_android.notice.get.GetChatRoomResponse
=======

import com.woong.woong_android.map.get.GetLocationResponse
import com.woong.woong_android.map.put.PutLocationRegisterResponse
import com.woong.woong_android.map.put.PutLocationRegisterResponseData

import com.woong.woong_android.market.get.GetBookmarkResponse

import com.woong.woong_android.myproduct.get.GetCartResponse
import com.woong.woong_android.myproduct.post.PostCartResponse
import com.woong.woong_android.notice.post.PostReviewResponse
import com.woong.woong_android.notice.post.ReviewWriteData
>>>>>>> 05a4be279cc4c1dad6f62b96792e9a4bdab157eb
import com.woong.woong_android.seller_market.post.PostBookmarkResponse
import retrofit2.http.*
import retrofit2.Call


interface NetworkService {
    //주소를 키워드로 검색시 연관 주소 목록들 가져오기 (손대지 마세요!!)
    @GET("v2/local/search/keyword.json")
    fun getLocationList(@Header("Authorization") header: String,
                        @Query("query") query: String): Call<GetLocationListResponse>


    //////////////////////// //주석과 함께 메소드(GET,POST 등등)적어주세요////////////////////////////////////////////


    //////////////////////마켓소개페이지 부분//////////////////////////////////////////////////////////////
    @GET("market/info/{market_id}") //마켓 첫 페이지
    fun getMarketDetail(@Header("usertoken") user: String?,
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

    @POST("/account/signin/app") //소비자로그인하기
    fun postSignInApp(@Body signin : PostSignInAppResponseData):Call<PostSignInAppResponse>

    @POST("/account/signup")//소비자 회원가입하기
    fun postSignup(@Body signup :PostSignUpResponseData ):Call<PostSignUpResponse>

    @PUT("/account/location") //위치 등록 or 변경 - 등록 ok
    fun putLocationRegister(@Header("usertoken")user_token: String?, @Body locaion_register_change : PutLocationRegisterResponseData):Call<PutLocationRegisterResponse>

    @GET("/account/location")//위치 가져오기(맨위에)
    fun getLocation(@Header("usertoken")user_token:String?):Call<GetLocationResponse>

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    //EVA///////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @GET("/item/search") // 상품 검색하기
    fun getSearchItem(@Header ("usertoken")user_token: String?,
                      @Query ("keyword")keyword: String?) :Call<GetSearchItemResponse>

    @GET("/category/main/{main_id}/sub/{sub_id}")
    fun getSubItem(@Header ("usertoken")user_token: String?,
                   @Path("main_id") main_id: Int,
                   @Path("sub_id")sub_id: Int) : Call<GetSubItemResponse>

    @POST("/favorite/{item_id}")
    fun postFavorite(@Header("usertoken")user_token: String?,
                     @Path("item_id")item_id:Int):Call<PostFavoriteResponse>

    @DELETE("/favorite/{item_id}")
    fun delFavorite(@Header("usertoken")user_token: String?,
                    @Path("item_id")item_id:Int):Call<PostFavoriteResponse>

    @GET("/favorite")
    fun getFavorite(@Header("usertoken")user_token: String?):Call<GetFavoriteResponse>

    @POST("/cart/{item_id}")
    fun postCart(@Header("usertoken")user_token: String?,
                     @Path("item_id")item_id:Int):Call<PostCartResponse>

    @GET("/cart")
    fun getCart(@Header("usertoken")user_token: String?):Call<GetCartResponse>

    @DELETE("/cart/{item_id}")
    fun delCart(@Header("usertoken")user_token: String?,
                @Path("item_id")item_id: Int):Call<PostCartResponse>

    @POST("/bookmark/{market_id}")
    fun postBookmark(@Header("usertoken")user_token: String?,
                     @Path("market_id")market_id: Int):Call<PostBookmarkResponse>

    @GET("/bookmark")
    fun getBookmark(@Header("usertoken")user_token: String?):Call<GetBookmarkResponse>

<<<<<<< HEAD

    ////////////////////////////////////

    @GET("/chat/room") //채팅룸가져오기
    fun getChatRoom(@Header("usertoken")user_token: String?):Call<GetChatRoomResponse>

    @GET("/chat/message/{chatting_room_id}") //채팅메시지 가져오기
    fun getChatMessage(@Header("usertoken")user_token: String?,@Path("chatting_room_id")chat_room_id :Int):Call<ChatMessageListData>


=======
    @POST("/review/{market_id}")
    fun postReview(@Header("usertoken")user_token: String?,
                   @Path("market_id")market_id: Int,
                   @Body reviewWriteData: ReviewWriteData):Call<PostReviewResponse>
>>>>>>> 05a4be279cc4c1dad6f62b96792e9a4bdab157eb
}