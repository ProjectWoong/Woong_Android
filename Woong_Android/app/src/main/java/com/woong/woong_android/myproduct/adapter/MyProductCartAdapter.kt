package com.woong.woong_android.myproduct.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.myproduct.get.GetCartResponseData
import com.woong.woong_android.myproduct.post.PostCartResponse
import com.woong.woong_android.myproduct.viewholder.MyProductCartViewHolder
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_myproduct_cart.view.*
import retrofit2.Call
import retrofit2.Response

class MyProductCartAdapter(private var cartItems: ArrayList<GetCartResponseData>, var requestManager: RequestManager, val v: View) : RecyclerView.Adapter<MyProductCartViewHolder>() {

    var marketIds:ArrayList<Int> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductCartViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_cart_myproduct,parent,false)

        return MyProductCartViewHolder(mainView)
    }

    override fun getItemCount(): Int = cartItems.size
    override fun getItemViewType(position: Int): Int {
        return position
    }
    fun initTotal(holder: MyProductCartViewHolder, position: Int) {
        var proPrice=0
        var deliPrice=0
        marketIds=ArrayList()
        for (i in cartItems){
            proPrice += i.item_price
            if(!marketIds.contains(i.market_id)) {
                marketIds.add(i.market_id)
                deliPrice += i.delivery
            }
        }
        v.pdtotalnum_footer_myproduct.text = proPrice.toString()
        v.tv_deliver_myproduct.text = deliPrice.toString()+"원"
        v.totalnum_footer_myproduct.text = (proPrice + deliPrice).toString()
    }
    fun delTotal(holder: MyProductCartViewHolder, position: Int) {
        var proPrice=v.pdtotalnum_footer_myproduct.text.toString().toInt()
        var deliPrice=v.tv_deliver_myproduct.text.toString().substring(0,v.tv_deliver_myproduct.text.toString().length-1).toInt()
        proPrice -= cartItems[position].item_price * holder.quantity.text.toString().toInt()

        if(marketIds.contains(cartItems[position].market_id)) {
            if(!chkOther(cartItems[position].market_id, position)) {
                deliPrice -= cartItems[position].delivery
                marketIds.remove(cartItems[position].market_id)
            }
        }
        deliPrice -= cartItems[position].delivery
        v.pdtotalnum_footer_myproduct.text = proPrice.toString()
        v.tv_deliver_myproduct.text = deliPrice.toString()+"원"
        v.totalnum_footer_myproduct.text = (proPrice + deliPrice).toString()
    }
    fun plusTotal(holder: MyProductCartViewHolder, position: Int) {
        var proPrice=v.pdtotalnum_footer_myproduct.text.toString().toInt()
        var deliPrice= v.tv_deliver_myproduct.text.toString().substring(0,v.tv_deliver_myproduct.text.toString().length-1).toInt()
        proPrice += cartItems[position].item_price
        v.pdtotalnum_footer_myproduct.text = proPrice.toString()
        v.tv_deliver_myproduct.text = deliPrice.toString()+"원"
        v.totalnum_footer_myproduct.text = (proPrice + deliPrice).toString()
    }
    fun minusTotal(holder: MyProductCartViewHolder, position: Int) {
        var proPrice= v.pdtotalnum_footer_myproduct.text.toString().toInt()
        var deliPrice= v.tv_deliver_myproduct.text.toString().substring(0,v.tv_deliver_myproduct.text.toString().length-1).toInt()
        proPrice -= cartItems[position].item_price
        v.pdtotalnum_footer_myproduct.text = proPrice.toString()
        v.tv_deliver_myproduct.text = deliPrice.toString()+"원"
        v.totalnum_footer_myproduct.text = (proPrice + deliPrice).toString()
    }
    fun chkOther(market_id: Int, now: Int):Boolean{
        for(i in cartItems){
            if(i!=cartItems[now] && i.market_id==market_id)
                return true
        }
        return false
    }

    override fun onBindViewHolder(holder: MyProductCartViewHolder, position: Int) {
        requestManager.load(cartItems[position].file_key).apply {
            placeholder(R.drawable.flicker).thumbnail(requestManager.load(R.drawable.flicker))
        }.into(holder.productimg)
        holder.marketname.text = cartItems[position].carttitle
        holder.subtotal.text = cartItems[position].item_price.toString()
        holder.quantity.text = "1"
        holder.cost.text = cartItems[position].packging
        if(cartItems[position].delivery==0){
            holder.delivery.text = "무료"
        }else {
            holder.delivery.text = cartItems[position].delivery.toString() + "원"
        }
        initTotal(holder,position)

        /////////////////////////////////////
        // listener
        holder.del.setOnClickListener {
            var networkService: NetworkService = ApplicationController.instance.networkService

            val delCartItem = networkService.delCart(woong_usertoken.user_token,cartItems[position].item_id)
            delCartItem.enqueue(object: retrofit2.Callback<PostCartResponse>{
                override fun onFailure(call: Call<PostCartResponse>?, t: Throwable?) {
                }

                override fun onResponse(call: Call<PostCartResponse>?, response: Response<PostCartResponse>?) {
                    cartItems.remove(cartItems[position])
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position,itemCount)
                    delTotal(holder,position)
                }
            })
        }
        holder.plusbtn.setOnClickListener{
            holder.quantity.text = (holder.quantity.text.toString().toInt()+1).toString()
            holder.subtotal.text = (holder.quantity.text.toString().toInt() * cartItems[position].item_price).toString()
            plusTotal(holder,position)
        }
        holder.minusbtn.setOnClickListener{
            if(holder.quantity.text.toString().toInt()-1 > 0) {
                holder.quantity.text = (holder.quantity.text.toString().toInt() - 1).toString()
                holder.subtotal.text = (holder.quantity.text.toString().toInt() * cartItems.get(position).item_price).toString()
                minusTotal(holder,position)
            }
        }
    }
}