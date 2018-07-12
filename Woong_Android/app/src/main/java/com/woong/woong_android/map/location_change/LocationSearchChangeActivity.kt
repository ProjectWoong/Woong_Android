package com.woong.woong_android.map.location_change

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_change_location_search.*
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager


class LocationSearchChangeActivity : AppCompatActivity() {


    lateinit var imm:InputMethodManager
    val bundle = Bundle()
    var location_keyword=""

    override fun onPause() {
        super.onPause()
        if (isFinishing){
            overridePendingTransition(R.anim.slide_stay_down, R.anim.slide_out_down)
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_location_search)
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager //키보드 내리기위해서
        addFragment(LocationShowPreviousSearch())

//        rv_result_consumer_location_search.layoutManager = LinearLayoutManager(this)

        //if(btn_)
        et_change_search_main.setOnEditorActionListener { textView, i, keyEvent ->
            when(i){
                EditorInfo.IME_ACTION_SEARCH->{

                    location_keyword=  et_change_search_main.text.toString()

                    bundle.putString("keyword",location_keyword)
                    LocationSearchResult().arguments = bundle
                    replaceFragment(LocationSearchResult())
                    hideKeyboard()

                    true
                }

            }
            false
        }



//        btn_back_join_location_search.setOnClickListener {
//            val intent = Intent(applicationContext, MapActivity::class.java)
//            startActivity(intent)   // 전환될 액티비티로 넘어갈때
//        }

//        locationSearchItems = ArrayList()
//        locationSearchItems.add(LocationSearchItem("마포구 상수동 72-1", "와우산로 94"))
//
//        locationSearchAdapter = LocationSearchAdapter(locationSearchItems)
//        rv_result_consumer_location_search.layoutManager = LinearLayoutManager(this)
//        rv_result_consumer_location_search.adapter = locationSearchAdapter
    }


    fun hideKeyboard()
    {
        imm.hideSoftInputFromWindow( et_change_search_main.windowToken, 0);
    }
    fun addFragment(fragment: Fragment) {

        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.add(R.id.frame_show_change_locationlist,fragment)

        transaction.commit()

    }
    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.frame_show_change_locationlist,fragment)
        transaction.addToBackStack(null);
        transaction.commit()
    }


}
