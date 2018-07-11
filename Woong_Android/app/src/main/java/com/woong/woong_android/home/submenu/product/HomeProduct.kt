package com.woong.woong_android.home.submenu.product

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.home.adapter.HomeProductAdapter
import com.woong.woong_android.home.submenu.TitleName
import com.woong.woong_android.home.submenu.data.HomeProductData
import com.woong.woong_android.home.submenu.get.GetSearchItemResponse
import com.woong.woong_android.home.submenu.get.GetSearchItemResponseData
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.ResizeAnimation
import com.woong.woong_android.seller_market.SellerMarketActivity
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_product_home.*
import kotlinx.android.synthetic.main.fragment_product_home.view.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeProduct : Fragment(), View.OnClickListener{
    lateinit var imm : InputMethodManager
    lateinit var homeProductAdapter: HomeProductAdapter
    lateinit var homeProductItems: ArrayList<GetSearchItemResponseData>

    override fun onClick(v: View?) {
        val intent : Intent = Intent(context, SellerMarketActivity::class.java)
        SellerIdx.id = 1
        startActivity(intent)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_product_home,container,false)
        // object로 중분류 누른 메뉴 이름 가져오기
        v.tv_submenu_product.text = TitleName.name

        val dur : Long = 400
        v.btn_search_product.setOnClickListener {
            val rs  = ResizeAnimation(iv_searchwide_product, dpToPx(325F, activity!!.applicationContext).toInt())
            rs.duration = dur
            iv_searchwide_product.startAnimation(rs)
            btn_search_product.visibility = View.INVISIBLE
            iv_searchwide_product.visibility = View.VISIBLE
            btn_cart_product.visibility = View.INVISIBLE
            tv_cancel_product.visibility = View.VISIBLE
            Handler().postDelayed({
                et_search_product.visibility = View.VISIBLE
                iv_searchico_product.visibility = View.VISIBLE
            }, dur)
        }

        v.tv_cancel_product.setOnClickListener {
            val rs  = ResizeAnimation(iv_searchwide_product, dpToPx(30F, activity!!.applicationContext).toInt())
            rs.duration = dur
            iv_searchwide_product.startAnimation(rs)
            iv_searchwide_product.visibility = View.INVISIBLE
            iv_searchico_product.visibility = View.INVISIBLE
            et_search_product.visibility = View.INVISIBLE
            Handler().postDelayed({
                btn_search_product.visibility = View.VISIBLE
                btn_cart_product.visibility = View.VISIBLE
                tv_cancel_product.visibility = View.INVISIBLE
            }, dur)
        }
        v.et_search_product.setOnEditorActionListener { textView, i, keyEvent ->
            when(i){
                EditorInfo.IME_ACTION_SEARCH->{
                    getProductList(et_search_product.text.toString())
                    tv_submenu_product.text = et_search_product.text.toString()
                    imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager //키보드 내리기위해서
                    imm.hideSoftInputFromWindow(et_search_product.windowToken, 0)
                    true
                }
            }
            false
        }
        return v
    }
    fun getProductList(keyword:String?){
        var networkService: NetworkService = ApplicationController.instance.networkService
        var requestManager: RequestManager = Glide.with(this)

        val getSearchItem = networkService.getSearchItem(woong_usertoken.user_token, keyword)
        getSearchItem.enqueue(object: retrofit2.Callback<GetSearchItemResponse>{
            override fun onFailure(call: Call<GetSearchItemResponse>?, t: Throwable?) {
            }
            override fun onResponse(call: Call<GetSearchItemResponse>?, response: Response<GetSearchItemResponse>?) {
                if(response!!.isSuccessful){
                    homeProductItems = response.body().data.item_info
                    homeProductAdapter = HomeProductAdapter(homeProductItems, requestManager)
                    homeProductAdapter.setOnItemClickListener(this@HomeProduct)
                    rv_product_product.layoutManager = GridLayoutManager(context, 2)
                    rv_product_product.adapter = homeProductAdapter
                }
            }
        })
    }
    fun dpToPx(dp:Float, context: Context):Float{
        return (dp * context.resources.displayMetrics.density)
    }
}
object SellerIdx{
    var id : Int = 0
}