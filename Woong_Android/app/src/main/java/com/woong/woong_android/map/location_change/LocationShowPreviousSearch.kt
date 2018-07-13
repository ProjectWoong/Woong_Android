package com.woong.woong_android.map.location_change

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.woong.woong_android.R
import com.woong.woong_android.applicationcontroller.ApplicationController
import com.woong.woong_android.map.get.GetLocationHistoryResponse
import com.woong.woong_android.map.get.HistoryOfLoactionData
import com.woong.woong_android.network.NetworkService
import com.woong.woong_android.woong_usertoken
import kotlinx.android.synthetic.main.fragment_locationsearch_previous.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationShowPreviousSearch : Fragment(),View.OnClickListener {
    override fun onClick(p0: View?) {

    }

    lateinit var networkService: NetworkService
    lateinit var historyItems : ArrayList<HistoryOfLoactionData>
    lateinit var locationHistoryAdapter: LocationHistoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_locationsearch_previous,container,false)
        networkService = ApplicationController.instance.networkService
        var user_token = woong_usertoken.user_token

        val getLocationHistory = networkService.getLocationHistory(user_token)
        view.rv_previous_consumer_location_search.layoutManager = LinearLayoutManager(context)
        getLocationHistory.enqueue(object: Callback<GetLocationHistoryResponse>{
            override fun onFailure(call: Call<GetLocationHistoryResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetLocationHistoryResponse>?, response: Response<GetLocationHistoryResponse>?) {
                if(response!!.isSuccessful){
                    Toast.makeText(context,"dd",Toast.LENGTH_SHORT).show()
                    historyItems = response.body().data.get_location_history_result

                    locationHistoryAdapter = LocationHistoryAdapter(historyItems)
                    locationHistoryAdapter.setOnItemClickListner(this@LocationShowPreviousSearch)

                    view.rv_previous_consumer_location_search.adapter = locationHistoryAdapter


                }
            }

        })

        return view
    }
}