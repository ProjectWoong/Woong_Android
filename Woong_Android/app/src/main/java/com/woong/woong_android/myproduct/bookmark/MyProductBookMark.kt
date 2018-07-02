package com.woong.woong_android.myproduct.bookmark

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.woong.woong_android.R
import com.woong.woong_android.myproduct.adapter.MyProductAdapter
import com.woong.woong_android.myproduct.data.MyProductBookmarkData
import kotlinx.android.synthetic.main.fragment_myproduct_bookmark.view.*

class MyProductBookMark : Fragment() {
    lateinit var myProductAdapter: MyProductAdapter
    lateinit var myProductBookmarkItems : ArrayList<MyProductBookmarkData>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val v = inflater.inflate(R.layout.fragment_myproduct_bookmark,container,false)
        myProductBookmarkItems = ArrayList()

        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"뚜덩마켓","흙감자","1","kg","4000","당일배송",""))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"혜란마켓","흙감자","1","kg","6000","당일배송","무료배송"))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"아영마켓","흙감자","1","kg","2000","당일배송",""))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"곤듀마켓","흙감자","1","kg","3000","당일배송",""))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"지녕마켓","흙감자","1","kg","9000","당일배송",""))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"뚜덩마켓","흙감자","1","kg","4000","당일배송","무료배송"))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"뚜덩마켓","흙감자","1","kg","4000","당일배송",""))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"뚜덩마켓","흙감자","1","kg","4000","당일배송",""))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"뚜덩마켓","흙감자","1","kg","4000","무료배송",""))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"뚜덩마켓","흙감자","1","kg","4000","당일배송",""))
        myProductBookmarkItems.add(MyProductBookmarkData(R.drawable.ic_launcher_background,"뚜덩마켓","흙감자","1","kg","4000","당일배송",""))

        myProductAdapter = MyProductAdapter(myProductBookmarkItems)

        v.rv_bookmark_mymarket.layoutManager = GridLayoutManager(context,2)
        v.rv_bookmark_mymarket.adapter = myProductAdapter

        return v
    }
}