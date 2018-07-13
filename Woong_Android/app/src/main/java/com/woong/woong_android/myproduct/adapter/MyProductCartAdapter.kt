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
import retrofit2.Call
import retrofit2.Response

class MyProductCartAdapter(private var cartItems: ArrayList<GetCartResponseData>, var requestManager: RequestManager, v: View) : RecyclerView.Adapter<MyProductCartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductCartViewHolder {
        val mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_cart_myproduct,parent,false)

        return MyProductCartViewHolder(mainView)
    }

    override fun getItemCount(): Int = cartItems.size
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: MyProductCartViewHolder, position: Int) {
        requestManager.load(cartItems[position].file_key).into(holder.productimg)
        holder.marketname.text = cartItems[position].carttitle
        holder.subtotal.text = (holder.quantity.text.toString().toInt() * cartItems[position].item_price).toString()
        holder.cost.text = cartItems[position].packging
        if(cartItems[position].delivery==0){
            holder.delivery.text = "무료"
        }else {
            holder.delivery.text = cartItems[position].delivery.toString() + "원"
        }
        holder.quantity.text = "1"
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
                }
            })
        }
        holder.plusbtn.setOnClickListener{
            holder.quantity.text = (holder.quantity.text.toString().toInt()+1).toString()
            holder.subtotal.text = (holder.quantity.text.toString().toInt() * cartItems[position].item_price).toString()
        }
        holder.minusbtn.setOnClickListener{
            if(holder.quantity.text.toString().toInt()-1 > 0) {
                holder.quantity.text = (holder.quantity.text.toString().toInt() - 1).toString()
                holder.subtotal.text = (holder.quantity.text.toString().toInt() * cartItems.get(position).item_price).toString()
            }
        }

//        holder.checkbox.setOnClickListener {
//            if(holder.checkbox.isChecked){
//                holder.checkbox.
//                holder.checkbox.isChecked = false
//               holder.checkbox.isChecked = false
//            }else{
//                all_checkbox_header_myproduct
//                holder.checkbox.isChecked = true
//                holder.checkbox.isChecked = true
//            }
//        }
    }
}