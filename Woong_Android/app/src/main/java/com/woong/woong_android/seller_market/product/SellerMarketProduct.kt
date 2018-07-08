package com.woong.woong_android.seller_market.product

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.fragment_sellermarket_product.view.*

// 물품 클릭했을 때 SellerMarketProductDetail 뜨게 추가해야함
class SellerMarketProduct: Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        replaceFragment(SellerMarketProductDetail())
    }

    //    fun replaceFragment(fragment: Fragment) {
//        val fm = fragmentManager
//        val transaction = fm!!.beginTransaction()
//        transaction.replace(R.id.frame_fragment_main, fragment)
//        transaction.addToBackStack(null)    // 이전 상태를 백스택에 추가하여 사용자가 백버튼을 눌렀을때에 대한 호환성 추가
//        transaction.commit()
//    }
    fun replaceFragment(fragment: Fragment) {
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()
    // 어디에 띄워야하는지 잘 모르겠음viewpager_sellermarket
        transaction.replace(R.id.frame_sellermarket,fragment)
        //transaction.replace(R.id.frame_sellermarket,fragment)
        transaction.addToBackStack(null)    // 이전 상태를 백스택에 추가하여 사용자가 백버튼을 눌렀을때에 대한 호환성 추가
        transaction.commit()
    }




    lateinit var productItems : ArrayList<SellerMarketProductItem>
    lateinit var productAdapter : SellerMarketProductAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_sellermarket_product,container,false)

        productItems = ArrayList()
        productItems.add(SellerMarketProductItem(R.drawable.rv_item_image, "마켓이름", "상품이름", "1", "6000"))
        productItems.add(SellerMarketProductItem(R.drawable.rv_item_image, "마켓이름", "상품이름", "1", "6000"))
        productItems.add(SellerMarketProductItem(R.drawable.rv_item_image, "마켓이름", "상품이름", "1", "6000"))
        productItems.add(SellerMarketProductItem(R.drawable.rv_item_image, "마켓이름", "상품이름", "1", "6000"))
        productItems.add(SellerMarketProductItem(R.drawable.rv_item_image, "마켓이름", "상품이름", "1", "6000"))

        productAdapter = SellerMarketProductAdapter(productItems)
        productAdapter.setOnItemClickListener(this)

        v.rv_sellermarket_product.layoutManager = GridLayoutManager(context,2)
        v.rv_sellermarket_product.adapter = productAdapter

        return v
    }

}

