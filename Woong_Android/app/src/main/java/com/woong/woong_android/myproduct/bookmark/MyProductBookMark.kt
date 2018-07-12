package com.woong.woong_android.myproduct.bookmark

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.myproduct.adapter.MyProductBookmarkAdapter
import com.woong.woong_android.myproduct.get.GetFavoriteResponse
import com.woong.woong_android.myproduct.get.GetFavoriteResponseData
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_myproduct_bookmark.view.*
import retrofit2.Call
import retrofit2.Response

class MyProductBookMark : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var myProductBookmarkAdapter: MyProductBookmarkAdapter
    lateinit var myProductBookmarkItems : ArrayList<GetFavoriteResponseData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val v = inflater.inflate(R.layout.fragment_myproduct_bookmark,container,false)
        myProductBookmarkItems = ArrayList()

        var networkService: NetworkService = ApplicationController.instance.networkService
        var requestManager: RequestManager = Glide.with(this)

        val getFavoriteItem = networkService.getFavorite(woong_usertoken.user_token)
        getFavoriteItem.enqueue(object: retrofit2.Callback<GetFavoriteResponse>{
            override fun onFailure(call: Call<GetFavoriteResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetFavoriteResponse>?, response: Response<GetFavoriteResponse>?) {
                if(response!!.isSuccessful){
                    myProductBookmarkItems = response.body().data.favorite_info
                    myProductBookmarkAdapter = MyProductBookmarkAdapter(myProductBookmarkItems, requestManager)
                    myProductBookmarkAdapter.setOnItemClickListener(this@MyProductBookMark)
                    v.rv_bookmark_mymarket.layoutManager = GridLayoutManager(context, 2)
                    v.rv_bookmark_mymarket.adapter = myProductBookmarkAdapter
                }
            }
        })

        return v
    }
}