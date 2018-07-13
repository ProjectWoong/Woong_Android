package com.woong.woong_android.join.consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.woong.woong_android.join.consumer.post.PostSignUpResponse
import com.woong.woong_android.join.consumer.post.PostSignUpResponseData
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.login.LoginActivity
import com.woong.woong_android.network.NetworkService
import kotlinx.android.synthetic.main.activity_consumer_join_allergy.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllergyActivity : AppCompatActivity(),View.OnClickListener {
    var allergy_list : ArrayList<String> = arrayListOf()
    var idx = 0
    override fun onClick(p0: View?) {
       when(p0){
           buckwheat_join_allergy->{ //메밀 1
               if(buckwheat_join_allergy.isSelected == true){
                   buckwheat_join_allergy.isSelected = false
               }else {
                   buckwheat_join_allergy.isSelected = true
               }

           }
           wheat_join_allergy->{ //밀 2
               if(wheat_join_allergy.isSelected == true){
                   wheat_join_allergy.isSelected = false
               }else {
                   wheat_join_allergy.isSelected = true
               }
           }
           peach_join_allergy->{ //복숭아 3
               if( peach_join_allergy.isSelected == true){
                   peach_join_allergy.isSelected = false
               }else {
                   peach_join_allergy.isSelected = true
               }
           }
           soybean_join_allergy->{ //대두 4
               if( soybean_join_allergy.isSelected == true){
                   soybean_join_allergy.isSelected = false
               }else {
                   soybean_join_allergy.isSelected = true
               }
           }
           nuts_join_allergy->{ //견과류 5
               if(  nuts_join_allergy.isSelected == true){
                   nuts_join_allergy.isSelected = false
               }else {
                   nuts_join_allergy.isSelected = true
               }
           }
           tomato_join_allergy->{ //토마토 6
               if(tomato_join_allergy.isSelected == true){
                   tomato_join_allergy.isSelected = false
               }else {
                   tomato_join_allergy.isSelected = true
               }
           }
           egg_join_allergy->{ //난류 7
               if(egg_join_allergy.isSelected == true){
                   egg_join_allergy.isSelected = false
               }else {
                   egg_join_allergy.isSelected = true
               }
           }
           milk_join_allergy->{ //우유 8
               if( milk_join_allergy.isSelected == true){
                   milk_join_allergy.isSelected = false
               }else {
                   milk_join_allergy.isSelected = true
               }
           }
           onion_join_allergy->{ //양파 9
               if( onion_join_allergy.isSelected == true){
                   onion_join_allergy.isSelected = false
               }else {
                   onion_join_allergy.isSelected = true
               }
           }
       }
    }

    lateinit var networkService: NetworkService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_join_allergy)


        buckwheat_join_allergy.setOnClickListener(this)
        wheat_join_allergy.setOnClickListener(this)
        peach_join_allergy.setOnClickListener(this)
        soybean_join_allergy.setOnClickListener(this)
        nuts_join_allergy.setOnClickListener(this)
        tomato_join_allergy.setOnClickListener(this)
        egg_join_allergy.setOnClickListener(this)
        milk_join_allergy.setOnClickListener(this)
        onion_join_allergy.setOnClickListener(this)

        networkService = ApplicationController.instance.networkService

        var birth = intent.getStringExtra("birth")
        var name = intent.getStringExtra("name")
        var email = intent.getStringExtra("email")
        var pwd = intent.getStringExtra("pwd")
        var phone = intent.getStringExtra("phone")

        btn_complete_allergy.setOnClickListener {
            if(buckwheat_join_allergy.isSelected){
                allergy_list.add("1")
            }
            if(wheat_join_allergy.isSelected){
                allergy_list.add("2")
            }
            if(peach_join_allergy.isSelected){
                allergy_list.add("3")
            }
            if(soybean_join_allergy.isSelected){
                allergy_list.add("4")
            }
            if(nuts_join_allergy.isSelected){
                allergy_list.add("5")
            }
            if (tomato_join_allergy.isSelected){
                allergy_list.add("6")
            }
            if(egg_join_allergy.isSelected){
                allergy_list.add("7")
            }
            if(milk_join_allergy.isSelected){
                allergy_list.add("8")
            }
            if(onion_join_allergy.isSelected){
                allergy_list.add("9")
            }
            val postSignUpResponseData = PostSignUpResponseData(birth,name,email,pwd,phone,0,0,allergy_list)
            val postSignUp = networkService.postSignup(postSignUpResponseData)
            postSignUp.enqueue(object:Callback<PostSignUpResponse>{
                override fun onFailure(call: Call<PostSignUpResponse>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<PostSignUpResponse>?, response: Response<PostSignUpResponse>?) {
                    if(response!!.isSuccessful){
                        //Toast.makeText(applicationContext,"회원가입아 되라!",Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, LoginActivity::class.java)

                          startActivity(intent)   // 전환될 액티비티로 넘어갈때

                    }
                }

            })

//
//
//
//            val intent = Intent(applicationContext, MapActivity::class.java)
//
//            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
    }


}
