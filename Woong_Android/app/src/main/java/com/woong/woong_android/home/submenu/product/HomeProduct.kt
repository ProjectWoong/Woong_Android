package com.woong.woong_android.home.submenu.product

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.home.adapter.HomeProductAdapter
import com.woong.woong_android.home.submenu.TitleName
import com.woong.woong_android.home.submenu.data.HomeProductData
import kotlinx.android.synthetic.main.fragment_product_home.view.*

class HomeProduct : Fragment() {
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

        v.rv_product_product.layoutManager = GridLayoutManager(context, 2)
        v.rv_product_product.adapter = homeProductAdapter
        return v
    }
}