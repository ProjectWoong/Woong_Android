package com.woong.woong_android.home.submenu.product

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.woong.woong_android.*
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.home.adapter.HomeProductAdapter
import com.woong.woong_android.home.submenu.get.GetSearchItemResponse
import com.woong.woong_android.home.submenu.get.GetItemResponseData
import com.woong.woong_android.home.submenu.get.GetSubItemResponse
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.seller_market.ResizeAnimation
import com.woong.woong_android.seller_market.SellerMarketActivity
import kotlinx.android.synthetic.main.fragment_product_home.*
import kotlinx.android.synthetic.main.fragment_product_home.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeProduct : Fragment(), View.OnClickListener{
    lateinit var imm : InputMethodManager
    lateinit var homeProductAdapter: HomeProductAdapter
    lateinit var homeProductItems: ArrayList<GetItemResponseData>

    override fun onClick(v: View?) {
        val intent : Intent = Intent(context, SellerMarketActivity::class.java)
        SellerIdx.id = 1
        var idx : Int = this.rv_product_product.getChildAdapterPosition(v)
        woong_marketinfo.market_id = homeProductItems[idx].market_id
        woong_marketinfo.item_id = homeProductItems[idx].item_id
        startActivity(intent)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_product_home,container,false)
        // object로 중분류 누른 메뉴 이름 가져오기
        v.tv_submenu_product.text = TitleName.name
        if(TitleName.main_id!=0 && TitleName.sub_id!=0)
            getMenuProductList(TitleName.main_id, TitleName.sub_id)
      
        if(searchString.flag) {
            getSearchProductList(searchString.str)
            searchString.flag=false
            val rs  = ResizeAnimation(v.iv_searchwide_product, dpToPx(325F, activity!!.applicationContext).toInt())
            rs.duration = 0
            v.iv_searchwide_product.startAnimation(rs)
            v.btn_search_product.visibility = View.INVISIBLE
            v.iv_searchwide_product.visibility = View.VISIBLE
            v.btn_cart_product.visibility = View.INVISIBLE
            v.tv_cancel_product.visibility = View.VISIBLE
            v.et_search_product.visibility = View.VISIBLE
            v.iv_searchico_product.visibility = View.VISIBLE
        }
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
                    getSearchProductList(et_search_product.text.toString())
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
    fun getSearchProductList(keyword:String?){
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
    fun getMenuProductList(main_id:Int, sub_id:Int){
        var networkService: NetworkService = ApplicationController.instance.networkService
        var requestManager: RequestManager = Glide.with(this)

        val getSubItem = networkService.getSubItem(woong_usertoken.user_token, main_id, sub_id)
        getSubItem.enqueue(object: Callback<GetSubItemResponse>{
            override fun onFailure(call: Call<GetSubItemResponse>?, t: Throwable?) {
            }
            override fun onResponse(call: Call<GetSubItemResponse>?, response: Response<GetSubItemResponse>?) {
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