package com.woong.woong_android.seller_market

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.adapter.SmPagerAdapter
import com.woong.woong_android.seller_market.get.GetMarketInfoResponse
import com.woong.woong_android.home.product.SellerIdx
import com.woong.woong_android.seller_market.post.PostBookmarkResponse
import com.woong.woong_android.seller_market.product.SellerMarketProductDetail
import com.woong.woong_android.woong_marketinfo
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.activity_sellermarket.*
import kotlinx.android.synthetic.main.fragment_product_home.*
import kotlinx.android.synthetic.main.title_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SellerMarketActivity : AppCompatActivity() {
    lateinit var networkService: NetworkService

    lateinit var requestManager: RequestManager

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.frame_sellermarket,fragment)
        transaction.addToBackStack(null)    // 이전 상태를 백스택에 추가하여 사용자가 백버튼을 눌렀을때에 대한 호환성 추가
        transaction.commit()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sellermarket)
        requestManager = Glide.with(this)

        networkService = ApplicationController.instance.networkService




        val myProductPagerAdapter = SmPagerAdapter(supportFragmentManager) // 프래그먼트안에 뷰페이저 쓸경우 childFragmentManager써주세욤
        val viewPager = viewpager_sellermarket
        val tabLayout = tab_top_sellermarket

        viewPager.adapter = myProductPagerAdapter
        viewPager.currentItem = SellerIdx.id
        tabLayout.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"))
        tabLayout.setupWithViewPager(viewPager)
        if (SellerIdx.id == 1) {
            val bundle = Bundle()
            bundle.putInt("market_id", woong_marketinfo.market_id)
            bundle.putInt("item_id", woong_marketinfo.item_id)
            val smpd = SellerMarketProductDetail()
            smpd.arguments = bundle
            replaceFragment(smpd)
            SellerIdx.id = 0
        }

        getMarketInfo()

        setSupportActionBar(toolbar)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.title_layout)
        supportActionBar?.setShowHideAnimationEnabled(false)

        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset <= -1 * dpToPx(126.5f, applicationContext)) {
                toolbar.visibility = View.VISIBLE
                tab_top_sellermarket.setBackgroundColor(Color.WHITE)
                tab_top_sellermarket.setSelectedTabIndicatorColor(Color.parseColor("#529C77"))
                tab_top_sellermarket.setTabTextColors(Color.parseColor("#ADADAD"), Color.parseColor("#529C77"))
            } else {
                toolbar.visibility = View.INVISIBLE
                tab_top_sellermarket.setBackgroundColor(Color.parseColor("#529C77"))
                tab_top_sellermarket.setSelectedTabIndicatorColor(Color.WHITE)
                tab_top_sellermarket.setTabTextColors(Color.WHITE, Color.WHITE)
            }
        }
        appbar_sellermarket.addOnOffsetChangedListener(listener)
        ib_bookmark_sellermarket.setOnClickListener{
            val postBookmark = networkService.postBookmark(woong_usertoken.user_token, woong_marketinfo.market_id)
            postBookmark.enqueue(object : Callback<PostBookmarkResponse> {
                override fun onFailure(call: Call<PostBookmarkResponse>?, t: Throwable?) {
                }

                override fun onResponse(call: Call<PostBookmarkResponse>?, response: Response<PostBookmarkResponse>?) {
                    ib_bookmark_sellermarket.setImageResource(R.drawable.seller_market_intro_f_like_o)
                }
            })
        }
    }
    fun dpToPx(dp:Float, context: Context):Float{
        return (dp * context.resources.displayMetrics.density)
    }
    fun getAcbar(): ActionBar? {
        return supportActionBar
    }
    fun getMarketInfo(){

        //유저토큰(header)과 마켓아이디(path)
        var user_token = woong_usertoken.user_token
        var market_id = woong_marketinfo.market_id

        var getMarketInfo = networkService.getMarketDetail(user_token,market_id)
        getMarketInfo.enqueue(object : Callback<GetMarketInfoResponse> {
            override fun onFailure(call: Call<GetMarketInfoResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetMarketInfoResponse>?, response: Response<GetMarketInfoResponse>?) {
                if(response!!.isSuccessful){

                    tv_name_sellermarket.text = response.body().data.market_name
                    var free_flag = response.body().data.delivery
                    if(free_flag == 1){ //유료
                        tv_tag2_sellermarket.text = "#유료배송"
                    }else {
                        tv_tag2_sellermarket.text="#무료배송"
                    }

                    tv_distance_sellermarket.text = response.body().data.youandi
                    //num_bookmark_sellermarket.text = response.body().data[0].bookmark_count.toString()
                    tv_storename_title.text = response.body().data.market_name

                    requestManager.load(response.body().data.farmer_image_key).into(iv_profile_sellermarket)
                }
            }

        })

    }
}
