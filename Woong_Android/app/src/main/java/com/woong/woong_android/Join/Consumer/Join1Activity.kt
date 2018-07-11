package com.woong.woong_android.join.consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_consumer_join1.*

class Join1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumer_join1)



        //Spinner
        val spnYear = findViewById(R.id.spinner_year_consumer) as Spinner
        val spnMonth = findViewById(R.id.spinner_month_consumer) as Spinner
        val spnDay = findViewById(R.id.spinner_day_consumer) as Spinner

        val adapterYear = ArrayAdapter.createFromResource(this, R.array.date_year, android.R.layout.simple_spinner_item)
        val adapterMonth = ArrayAdapter.createFromResource(this, R.array.date_month, android.R.layout.simple_spinner_item)
        val adapterDay = ArrayAdapter.createFromResource(this, R.array.date_day, android.R.layout.simple_spinner_item)

        //Year Spinner
        spnYear.adapter = adapterYear

        var user_year = spnYear.selectedItem.toString()

//        spnYear.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//
//            }
//        }


        //Month Spinner
        spnMonth.adapter = adapterMonth

       var user_month = spnMonth.selectedItem.toString()
        /*
        spnMonth.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        */
        //Day Spinner
        spnDay.adapter = adapterDay
        var user_day = spnDay.selectedItem.toString()
        /*
        spnDay.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }*/

        var birth = user_day+user_month+user_day
        var name = name_join_consumer.text.toString()
        btn_next_consumer_join1.setOnClickListener {
            val intent = Intent(applicationContext, Join2Activity::class.java)

            intent.putExtra("birth",birth)
            intent.putExtra("name",name)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }

    }
}
