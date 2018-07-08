package com.woong.woong_android.network

import com.woong.woong_android.map.get.GetLocationListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkService{
    //주소를 키워드로 검색시 연관 주소 목록들 가져오기
    @GET("v2/local/search/keyword.json")
    fun getLocationList(@Header("Authorization") header: String,
                        @Query("query") query: String): Call<GetLocationListResponse>


    //주석과 함께 메소드(GET,POST 등등)적어주세요

}