package com.woong.woong_android.seller_market.product

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
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.get.GetSellerMarketProductResponse
import com.woong.woong_android.seller_market.get.GetSellerMarketProductResponseData
import com.woong.woong_android.woong_marketinfo
import kotlinx.android.synthetic.main.fragment_sellermarket_product.*
import kotlinx.android.synthetic.main.fragment_sellermarket_product.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// 물품 클릭했을 때 SellerMarketProductDetail 뜨게 추가해야함
class SellerMarketProduct: Fragment(), View.OnClickListener {
    val bundle = Bundle()

    override fun onClick(v: View?) {
        var idx : Int = this.rv_sellermarket_product.getChildAdapterPosition(v)
        bundle.putInt("market_id",productItems[idx].market_id)
        bundle.putInt("item_id",productItems[idx].item_id)
        //Log.v("넘겨죽이ㅣ잉ㅇ",productItems[idx].item_id.toString())
        replaceFragment(SellerMarketProductDetail())
    }


    fun replaceFragment(fragment: Fragment) {
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.frame_sellermarket,fragment)
        transaction.addToBackStack(null)    // 이전 상태를 백스택에 추가하여 사용자가 백버튼을 눌렀을때에 대한 호환성 추가
        transaction.commit()
    }




    lateinit var productItems : ArrayList<GetSellerMarketProductResponseData>
    lateinit var productAdapter : SellerMarketProductAdapter
    lateinit var networkService: NetworkService
    lateinit var requestManager: RequestManager



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sellermarket_product,container,false)

        requestManager = Glide.with(this)

        v.btn_sort_name_product.setOnClickListener {
            getMarketProductbyName(v)
        }
        v.btn_sort_best_product.setOnClickListener {
            getMarketProductbyBest(v)
        }
      getMarketProductbyName(v)//맨처음에는 이름순으로 정렬!

        return v
    }

    fun getMarketProductbyName(v:View){
        networkService = ApplicationController.instance.networkService

        var market_id = woong_marketinfo.market_id
        //option (query), market_id(path)
        var getMarketProductbyname = networkService.getMarketProductList(market_id,"name")
        getMarketProductbyname.enqueue(object: Callback<GetSellerMarketProductResponse>{
            override fun onFailure(call: Call<GetSellerMarketProductResponse>?, t: Throwable?) {


            }

            override fun onResponse(call: Call<GetSellerMarketProductResponse>?, response: Response<GetSellerMarketProductResponse>?) {
                if(response!!.isSuccessful){
                    productItems = response.body().data
                    productAdapter = SellerMarketProductAdapter(productItems,requestManager)
                    productAdapter.setOnItemClickListener(this@SellerMarketProduct)


                    v.rv_sellermarket_product.layoutManager = GridLayoutManager(context,2)
                    v.rv_sellermarket_product.adapter = productAdapter


                }
            }

        })

    }
    fun getMarketProductbyBest(v:View){
        networkService = ApplicationController.instance.networkService
        var market_id = woong_marketinfo.market_id

        var getMarketProductbybest = networkService.getMarketProductList(market_id,"best")
        getMarketProductbybest.enqueue(object: Callback<GetSellerMarketProductResponse>{
            override fun onFailure(call: Call<GetSellerMarketProductResponse>?, t: Throwable?) {


            }

            override fun onResponse(call: Call<GetSellerMarketProductResponse>?, response: Response<GetSellerMarketProductResponse>?) {
                if(response!!.isSuccessful){
                    productItems = response.body().data
                    productAdapter = SellerMarketProductAdapter(productItems,requestManager)
                    productAdapter.setOnItemClickListener(this@SellerMarketProduct)

                    v.rv_sellermarket_product.layoutManager = GridLayoutManager(context,2)
                    v.rv_sellermarket_product.adapter = productAdapter

                }
            }

        })

    }

}

