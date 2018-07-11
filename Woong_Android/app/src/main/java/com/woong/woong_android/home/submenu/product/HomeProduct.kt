package com.woong.woong_android.home.submenu.product

import android.content.Context
import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.woong.woong_android.R
import com.woong.woong_android.home.adapter.HomeProductAdapter
import com.woong.woong_android.home.submenu.TitleName
import com.woong.woong_android.home.submenu.data.HomeProductData
import com.woong.woong_android.seller_market.ResizeAnimation
import com.woong.woong_android.seller_market.SellerMarketActivity
import kotlinx.android.synthetic.main.fragment_product_home.*
import kotlinx.android.synthetic.main.fragment_product_home.view.*

class HomeProduct : Fragment(), View.OnClickListener{
    override fun onClick(v: View?) {
        Log.d("asd","dasd")
        val intent : Intent = Intent(context, SellerMarketActivity::class.java)
        SellerIdx.id = 1
        startActivity(intent)
    }
    lateinit var homeProductAdapter: HomeProductAdapter
    lateinit var homeProductItems: ArrayList<HomeProductData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_product_home,container,false)
        // object로 중분류 누른 메뉴 이름 가져오기
        v.tv_submenu_product.text = TitleName.name

        homeProductItems = ArrayList()

        homeProductItems.add(HomeProductData(R.drawable.comsumer_allergy_select_ed_milk, "아영마켓","돼지감자","3","kg","7000","당일배송","무료배송",true))
        homeProductItems.add(HomeProductData(R.drawable.comsumer_allergy_select_ed_milk, "아영마켓","돼지감자","3","kg","7000","당일배송","무료배송",true))
        homeProductItems.add(HomeProductData(R.drawable.comsumer_allergy_select_ed_milk, "아영마켓","돼지감자","3","kg","7000","당일배송","무료배송",false))

        homeProductAdapter = HomeProductAdapter(homeProductItems)
        homeProductAdapter.setOnItemClickListener(this)

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
                et_search_main.visibility = View.VISIBLE
                iv_searchico_product.visibility = View.VISIBLE
            }, dur)
        }

        v.tv_cancel_product.setOnClickListener {
            val rs  = ResizeAnimation(iv_searchwide_product, dpToPx(30F, activity!!.applicationContext).toInt())
            rs.duration = dur
            iv_searchwide_product.startAnimation(rs)
            iv_searchwide_product.visibility = View.INVISIBLE
            iv_searchico_product.visibility = View.INVISIBLE
            et_search_main.visibility = View.INVISIBLE
            Handler().postDelayed({
                btn_search_product.visibility = View.VISIBLE
                btn_cart_product.visibility = View.VISIBLE
                tv_cancel_product.visibility = View.INVISIBLE
            }, dur)
        }


        v.rv_product_product.layoutManager = GridLayoutManager(context, 2)
        v.rv_product_product.adapter = homeProductAdapter
        return v
    }
    fun dpToPx(dp:Float, context: Context):Float{
        return (dp * context.resources.displayMetrics.density)
    }
}
object SellerIdx{
    var id : Int = 0
}