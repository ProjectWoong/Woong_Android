package com.woong.woong_android.join.marketer.market

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_join_map.*
import kotlinx.android.synthetic.main.activity_market_enroll1.*
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapReverseGeoCoder
import net.daum.mf.map.api.MapView

class Enroll1Activity : AppCompatActivity(),MapReverseGeoCoder.ReverseGeoCodingResultListener{
    override fun onReverseGeoCoderFailedToFindAddress(p0: MapReverseGeoCoder?) {

    }

    override fun onReverseGeoCoderFoundAddress(p0: MapReverseGeoCoder?, p1: String?) {
        farm_location_confirm.text=p1
    }

    lateinit var mReverseGeoCoder:MapReverseGeoCoder
    var flag: Int? =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market_enroll1)
        flag = intent?.getIntExtra("flag",0)
        val mapView = MapView(this)
        mapView.setDaumMapApiKey("5b9f84f71895898003a9683274d06a39")
        val container = findViewById<View>(R.id.market_map_view) as RelativeLayout

        if(flag == 1){
            mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOff
            mapView.setShowCurrentLocationMarker(false)
            mapView.removeAllPOIItems()

            val DEFAULT_MARKER_POINT = MapPoint.mapPointWithGeoCoord(intent.getStringExtra("real_address_y").toDouble(), intent.getStringExtra("real_address_x").toDouble() )
            farm_location_confirm.text = intent.getStringExtra("search_address")

            var mDefaultMarker = MapPOIItem()

            mDefaultMarker.itemName = ""
            mDefaultMarker.tag = 0
            mDefaultMarker.customCalloutBalloon =null
            mDefaultMarker.mapPoint = DEFAULT_MARKER_POINT
            mDefaultMarker.markerType = MapPOIItem.MarkerType.CustomImage

            mDefaultMarker.customImageResourceId = R.drawable.custom_marker_red
            mDefaultMarker.isCustomImageAutoscale = false
            mDefaultMarker.setCustomImageAnchor(0.5f, 1.0f)


            mapView.addPOIItem(mDefaultMarker)
            //mapView.selectPOIItem(mDefaultMarker, true)
            mapView.setMapCenterPoint(DEFAULT_MARKER_POINT, false)
        }else{
            val trackingImageAnchorPointOffset = MapPOIItem.ImageOffset(28, 28) // 좌하단(0,0) 기준 앵커포인트 오프셋
            mapView.setCustomCurrentLocationMarkerTrackingImage(R.drawable.custom_marker_red, trackingImageAnchorPointOffset)
            mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
        }


        container.addView(mapView)

        btn_currentloc_marketer.setOnClickListener {
            mapView.removeAllPOIItems()
            mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
            mReverseGeoCoder = MapReverseGeoCoder("5b9f84f71895898003a9683274d06a39", mapView.mapCenterPoint, this@Enroll1Activity, this@Enroll1Activity)
            mReverseGeoCoder.startFindingAddress()
        }

        btn_next_enroll1.setOnClickListener {
            val intent = Intent(applicationContext, Enroll2Activity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }

        farm_location_confirm.setOnClickListener { //농장 위치 바꿀떄
            val intent = Intent(applicationContext, Enroll1SearchActivity::class.java)
            startActivity(intent)
        }
    }
}
