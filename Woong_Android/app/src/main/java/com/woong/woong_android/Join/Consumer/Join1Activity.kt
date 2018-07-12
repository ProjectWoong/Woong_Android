package com.woong.woong_android.join.consumer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.woong.woong_android.R
import com.woong.woong_android.home.submenu.TitleName.name
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

        //Month Spinner
        spnMonth.adapter = adapterMonth

        //Day Spinner
        spnDay.adapter = adapterDay




        btn_next_consumer_join1.setOnClickListener {
            var user_year = spnYear.selectedItem.toString()
            var user_month = spnMonth.selectedItem.toString()
            var user_day = spnDay.selectedItem.toString()

            var birth = user_year+user_month+user_day
            var name = name_join_consumer.text.toString()
            val intent = Intent(applicationContext, Join2Activity::class.java)

            intent.putExtra("birth",birth)
            intent.putExtra("name",name)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }

    }
}
