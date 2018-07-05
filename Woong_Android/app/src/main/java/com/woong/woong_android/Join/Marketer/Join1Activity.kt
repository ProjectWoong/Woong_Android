package com.woong.woong_android.Join.Marketer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_marketer_join1.*

class Join1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marketer_join1)

        btn_next_join1.setOnClickListener {
            val intent = Intent(applicationContext, Join2Activity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }

        //Spinner
        val spnYear = findViewById(R.id.spinner_year) as Spinner
        val spnMonth = findViewById(R.id.spinner_month) as Spinner
        val spnDay = findViewById(R.id.spinner_day) as Spinner

        val adapterYear = ArrayAdapter.createFromResource(this, R.array.date_year, android.R.layout.simple_spinner_item)
        val adapterMonth = ArrayAdapter.createFromResource(this, R.array.date_month, android.R.layout.simple_spinner_item)
        val adapterDay = ArrayAdapter.createFromResource(this, R.array.date_day, android.R.layout.simple_spinner_item)

        //Year Spinner
        spnYear.adapter = adapterYear
        /*
        spnYear.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }*/

        //Month Spinner
        spnMonth.adapter = adapterMonth
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
        /*
        spnDay.onItemSelectedListener = object:AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }*/

    }
}
