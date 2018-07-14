package com.woong.woong_android.seller_market.review

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.myproduct.payment.dialog.FailPaymentDialog
import com.woong.woong_android.myproduct.payment.dialog.PaymentDialog
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.adapter.SellerMarketReviewAdapter
import com.woong.woong_android.seller_market.get.GetMarketReviewResponse
import com.woong.woong_android.seller_market.get.GetMarketReviewResponseData
import com.woong.woong_android.seller_market.get.ImagesMarketReviewData
import com.woong.woong_android.woong_marketinfo
import kotlinx.android.synthetic.main.fragment_sellermarket_review.*
import kotlinx.android.synthetic.main.fragment_sellermarket_review.view.*
import kotlinx.android.synthetic.main.item_sellermarket_review.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SellerMarketReview: Fragment() {
    lateinit var sellerMarketReviewAdapter : SellerMarketReviewAdapter
    lateinit var reviewItems : ArrayList<GetMarketReviewResponseData>
    lateinit var networkService: NetworkService
    lateinit var requestManager: RequestManager
    lateinit var imageItems : ArrayList<ImagesMarketReviewData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sellermarket_review,container,false)

        requestManager = Glide.with(this)


        var displayMetrics = context!!.resources.displayMetrics
        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels


        networkService = ApplicationController.instance.networkService
        var market_id = woong_marketinfo.market_id

        //market_id (path)
        var getMarketReview = networkService.getMarketReview(market_id)
        getMarketReview.enqueue(object:Callback<GetMarketReviewResponse>{
            override fun onFailure(call: Call<GetMarketReviewResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetMarketReviewResponse>?, response: Response<GetMarketReviewResponse>?) {
                if(response!!.isSuccessful){

                    var first = response.body().rate.rate_speed
                    var second = response.body().rate.rate_taste
                    var third = response.body().rate.rate_fresh
                    var fourth = response.body().rate.rate_kindness

                    var avr = (first+second+third+fourth)/4

                    v.avr_rating_marketreview.rating = avr.toFloat()

                    v.first_rating_marketreview.rating = first.toFloat()
                    v.second_rating_marketreview.rating = second.toFloat()
                    v.third_rating_marketreview.rating = third.toFloat()
                    v.fourth_rating_marketreview.rating = fourth.toFloat()
1
                    reviewItems = response.body().reviews
                    sellerMarketReviewAdapter = SellerMarketReviewAdapter(reviewItems,0)
                    v.rv_sellermarket_review.layoutManager = LinearLayoutManager(context)
                    v.rv_sellermarket_review.adapter = sellerMarketReviewAdapter

                    imageItems = response.body().images

                    if(imageItems.size == 0){

                    }else if(imageItems.size == 1){
                        requestManager.load(imageItems[0].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img1_review)

                    }else if(imageItems.size == 2){
                        requestManager.load(imageItems[0].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img1_review)
                        requestManager.load(imageItems[1].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img2_review)

                    }else if(imageItems.size == 3){
                        requestManager.load(imageItems[0].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img1_review)
                        requestManager.load(imageItems[1].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img2_review)
                        requestManager.load(imageItems[2].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img3_review)

                    }else if( imageItems.size == 4){
                        requestManager.load(imageItems[0].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img1_review)
                        requestManager.load(imageItems[1].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img2_review)
                        requestManager.load(imageItems[2].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img3_review)
                        requestManager.load(imageItems[3].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img4_review)


                    }else if(imageItems.size == 5){
                        requestManager.load(imageItems[0].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img1_review)
                        requestManager.load(imageItems[1].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img2_review)
                        requestManager.load(imageItems[2].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img3_review)
                        requestManager.load(imageItems[3].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img4_review)
                        requestManager.load(imageItems[4].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img5_review)


                    }else if (imageItems.size == 6){
                        requestManager.load(imageItems[0].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img1_review)
                        requestManager.load(imageItems[1].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img2_review)
                        requestManager.load(imageItems[2].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img3_review)
                        requestManager.load(imageItems[3].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img4_review)
                        requestManager.load(imageItems[4].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img5_review)
                        requestManager.load(imageItems[5].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img6_review)


                    }else if( imageItems.size == 7){
                        requestManager.load(imageItems[0].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img1_review)
                        requestManager.load(imageItems[1].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img2_review)
                        requestManager.load(imageItems[2].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img3_review)
                        requestManager.load(imageItems[3].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img4_review)
                        requestManager.load(imageItems[4].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img5_review)
                        requestManager.load(imageItems[5].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img6_review)
                        requestManager.load(imageItems[6].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img7_review)


                    }else if(imageItems.size == 8){
                        requestManager.load(imageItems[0].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img1_review)
                        requestManager.load(imageItems[1].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img2_review)
                        requestManager.load(imageItems[2].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img3_review)
                        requestManager.load(imageItems[3].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img4_review)
                        requestManager.load(imageItems[4].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img5_review)
                        requestManager.load(imageItems[5].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img6_review)
                        requestManager.load(imageItems[6].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img7_review)
                        requestManager.load(imageItems[7].file_key).apply {
                            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
                        }.into(v.img8_review)

                    }

                    v.img1_review.setOnClickListener {
                        if(imageItems.size==1||imageItems.size==2||imageItems.size==3||imageItems.size==4||imageItems.size==5||imageItems.size==6||imageItems.size==7||imageItems.size==8){
                            var image_dialog = ImageDialog(context,imageItems[0].file_key)

                            var wm : WindowManager.LayoutParams = image_dialog.window.attributes
                            wm.copyFrom(image_dialog.window.attributes)

                            image_dialog.show()
                        }

                    }
                    v.img2_review.setOnClickListener {
                        if(imageItems.size==2||imageItems.size==3||imageItems.size==4||imageItems.size==5||imageItems.size==6||imageItems.size==7||imageItems.size==8){
                            var image_dialog = ImageDialog(context,imageItems[1].file_key)

                            var wm : WindowManager.LayoutParams = image_dialog.window.attributes
                            wm.copyFrom(image_dialog.window.attributes)

                            image_dialog.show()
                        }

                    }
                    v.img3_review.setOnClickListener {
                        if(imageItems.size==3||imageItems.size==4||imageItems.size==5||imageItems.size==6||imageItems.size==7||imageItems.size==8){
                            var image_dialog = ImageDialog(context,imageItems[2].file_key)

                            var wm : WindowManager.LayoutParams = image_dialog.window.attributes
                            wm.copyFrom(image_dialog.window.attributes)

                            image_dialog.show()
                        }

                    }
                    v.img4_review.setOnClickListener {
                        if(imageItems.size==4||imageItems.size==5||imageItems.size==6||imageItems.size==7||imageItems.size==8){
                            var image_dialog = ImageDialog(context,imageItems[3].file_key)

                            var wm : WindowManager.LayoutParams = image_dialog.window.attributes
                            wm.copyFrom(image_dialog.window.attributes)

                            image_dialog.show()
                        }


                    }
                    v.img5_review.setOnClickListener {
                        if(imageItems.size==5||imageItems.size==6||imageItems.size==7||imageItems.size==8){
                            var image_dialog = ImageDialog(context,imageItems[4].file_key)

                            var wm : WindowManager.LayoutParams = image_dialog.window.attributes
                            wm.copyFrom(image_dialog.window.attributes)

                            image_dialog.show()
                        }

                    }
                    v.img6_review.setOnClickListener {
                        if(imageItems.size==6||imageItems.size==7||imageItems.size==8){
                            var image_dialog = ImageDialog(context,imageItems[5].file_key)

                            var wm : WindowManager.LayoutParams = image_dialog.window.attributes
                            wm.copyFrom(image_dialog.window.attributes)

                            image_dialog.show()
                        }

                    }
                    v.img7_review.setOnClickListener {
                        if(imageItems.size==7||imageItems.size==8){
                            var image_dialog = ImageDialog(context,imageItems[6].file_key)

                            var wm : WindowManager.LayoutParams = image_dialog.window.attributes
                            wm.copyFrom(image_dialog.window.attributes)

                            image_dialog.show()
                        }

                    }
                    v.img8_review.setOnClickListener {
                        if(imageItems.size==8){
                            var image_dialog = ImageDialog(context,imageItems[7].file_key)

                            var wm : WindowManager.LayoutParams = image_dialog.window.attributes
                            wm.copyFrom(image_dialog.window.attributes)

                            image_dialog.show()
                        }

                    }


                    v.btn_show_more_review.setOnClickListener {
                        sellerMarketReviewAdapter = SellerMarketReviewAdapter(reviewItems,1)
                        v.rv_sellermarket_review.layoutManager = LinearLayoutManager(context)
                        v.rv_sellermarket_review.adapter = sellerMarketReviewAdapter
                    }





                }
            }

        })






        return v
    }
}