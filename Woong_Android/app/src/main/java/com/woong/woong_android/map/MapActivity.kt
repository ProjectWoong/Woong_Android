package com.woong.woong_android.map

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.woong.woong_android.MainActivity
import net.daum.mf.map.api.MapView
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_join_map.*
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.n.api.internal.NativeMapLocationManager.setCurrentLocationTrackingMode
import net.daum.mf.map.n.api.internal.NativeMapLocationManager.setShowCurrentLocationMarker
import android.provider.SyncStateContract.Helpers.update
import android.content.pm.PackageManager
import com.kakao.util.maps.helper.Utility.getPackageInfo
import android.content.pm.PackageInfo
import android.support.v4.app.NotificationCompat
import android.util.Base64
import android.util.Log
import net.daum.mf.map.api.MapReverseGeoCoder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


//참고사이트 http://es1015.tistory.com/296
class MapActivity : AppCompatActivity(),MapReverseGeoCoder.ReverseGeoCodingResultListener {
    lateinit var mReverseGeoCoder:MapReverseGeoCoder
    override fun onReverseGeoCoderFailedToFindAddress(p0: MapReverseGeoCoder?) { //좌표로 주소를 찾는데 실패했을때

    }

    override fun onReverseGeoCoderFoundAddress(p0: MapReverseGeoCoder?, p1: String?) { //좌표로 주소를 찾는데 성공했을때
        name_location_join_map.text = p1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_map)

//        try {
//            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
//            for (signature in info.signatures) {
//                val md = MessageDigest.getInstance("SHA")
//                md.update(signature.toByteArray())
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
//
//            }
//        } catch (e: PackageManager.NameNotFoundException) {
//            e.printStackTrace()
//        } catch (e: NoSuchAlgorithmException) {
//            e.printStackTrace()
//        }
/* 키해쉬 구하기*/
        try {
            val info = packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {

        } catch (e: NoSuchAlgorithmException) {

        }


        val mapView = MapView(this)
        mapView.setDaumMapApiKey("5b9f84f71895898003a9683274d06a39")

        val container = findViewById<View>(R.id.map_view) as RelativeLayout
       // mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithHeading)
        mReverseGeoCoder = MapReverseGeoCoder("5b9f84f71895898003a9683274d06a39", mapView.mapCenterPoint, this@MapActivity, this@MapActivity)
        mReverseGeoCoder.startFindingAddress()

        val trackingImageAnchorPointOffset = MapPOIItem.ImageOffset(28, 28) // 좌하단(0,0) 기준 앵커포인트 오프셋
        mapView.setCustomCurrentLocationMarkerTrackingImage(R.drawable.custom_arrow_map_present_tracking, trackingImageAnchorPointOffset)
        mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading



        container.addView(mapView)


        btn_presentloc_join_map.setOnClickListener {
            mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
            mReverseGeoCoder = MapReverseGeoCoder("5b9f84f71895898003a9683274d06a39", mapView.mapCenterPoint, this@MapActivity, this@MapActivity)
            mReverseGeoCoder.startFindingAddress()
        }

        btn_search_join_map.setOnClickListener {
            val intent = Intent(applicationContext, LocationSearchActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
        btn_decided_join_map.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
    }
}
