package com.woong.woong_android.map

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.woong.woong_android.MainActivity
import com.woong.woong_android.R
import kotlinx.android.synthetic.main.activity_join_map.*
import android.content.pm.PackageManager
import android.location.LocationManager
import android.util.Base64
import android.util.Log
import com.woong.woong_android.map.location_register.LocationSearchActivity
import net.daum.mf.map.api.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import net.daum.mf.map.api.MapPOIItem
import android.support.design.widget.CoordinatorLayout.Behavior.setTag
import android.view.WindowManager
import com.woong.woong_android.location
import com.woong.woong_android.login.FirstLoginVO
import com.woong.woong_android.login.LoginActivity
import com.woong.woong_android.myproduct.payment.dialog.FailPaymentDialog
import com.woong.woong_android.myproduct.payment.dialog.PaymentDialog
import io.realm.Realm
import net.daum.mf.map.api.MapPoint




//참고사이트 http://es1015.tistory.com/296
class MapActivity : AppCompatActivity(),MapReverseGeoCoder.ReverseGeoCodingResultListener {
    lateinit var flRealm:Realm
    lateinit var firstLoginVO: FirstLoginVO
    lateinit var mReverseGeoCoder:MapReverseGeoCoder
    override fun onReverseGeoCoderFailedToFindAddress(p0: MapReverseGeoCoder?) { //좌표로 주소를 찾는데 실패했을때

    }

    override fun onReverseGeoCoderFoundAddress(p0: MapReverseGeoCoder?, p1: String?) { //좌표로 주소를 찾는데 성공했을때
        name_location_join_map.text = p1
    }
    var flag: Int? =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join_map)
        var displayMetrics = applicationContext.resources.displayMetrics
        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels

        var review_dialog = DialogIsRightLocation(this)

        var wm : WindowManager.LayoutParams = review_dialog.window.attributes
        wm.copyFrom(review_dialog.window.attributes)

        flag = intent?.getIntExtra("flag",0)

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


        if(flag == 1){
            mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOff
            mapView.setShowCurrentLocationMarker(false)
            mapView.removeAllPOIItems()

            val DEFAULT_MARKER_POINT = MapPoint.mapPointWithGeoCoord(intent.getStringExtra("real_address_y").toDouble(), intent.getStringExtra("real_address_x").toDouble() )
            name_location_join_map.text = intent.getStringExtra("search_address")

            location.latitude = intent.getStringExtra("real_address_y").toDouble()
            location.logitude = intent.getStringExtra("real_address_x").toDouble()
            location.real_address = intent.getStringExtra("search_address")

            var mDefaultMarker = MapPOIItem()
            val name = "Default Marker"
            mDefaultMarker.itemName = ""
            mDefaultMarker.tag = 0
            mDefaultMarker.customCalloutBalloon =null
            mDefaultMarker.mapPoint = DEFAULT_MARKER_POINT
            mDefaultMarker.markerType = MapPOIItem.MarkerType.CustomImage

            mDefaultMarker.customImageResourceId = R.drawable.setting_location_1_woong
            mDefaultMarker.isCustomImageAutoscale = false
            mDefaultMarker.setCustomImageAnchor(0.5f, 1.0f)


            mapView.addPOIItem(mDefaultMarker)
            //mapView.selectPOIItem(mDefaultMarker, true)
            mapView.setMapCenterPoint(DEFAULT_MARKER_POINT, false)
        }else{
            val trackingImageAnchorPointOffset = MapPOIItem.ImageOffset(28, 28) // 좌하단(0,0) 기준 앵커포인트 오프셋
            mapView.setCustomCurrentLocationMarkerTrackingImage(R.drawable.setting_location_1_woong, trackingImageAnchorPointOffset)
            mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading

            location.latitude = mapView.mapCenterPoint.mapPointGeoCoord.latitude
            location.logitude =  mapView.mapCenterPoint.mapPointGeoCoord.longitude
            location.real_address = name_location_join_map.text.toString()
        }


        container.addView(mapView)

        var user_id = intent.getStringExtra("user_id")

        btn_presentloc_join_map.setOnClickListener {
            mapView.removeAllPOIItems()
            val trackingImageAnchorPointOffset = MapPOIItem.ImageOffset(28, 28) // 좌하단(0,0) 기준 앵커포인트 오프셋
            mapView.setCustomCurrentLocationMarkerTrackingImage(R.drawable.setting_location_1_woong, trackingImageAnchorPointOffset)
            mapView.currentLocationTrackingMode = MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
            mReverseGeoCoder = MapReverseGeoCoder("5b9f84f71895898003a9683274d06a39", mapView.mapCenterPoint, this@MapActivity, this@MapActivity)
            mReverseGeoCoder.startFindingAddress()

            location.latitude = mapView.mapCenterPoint.mapPointGeoCoord.latitude
            location.logitude =  mapView.mapCenterPoint.mapPointGeoCoord.longitude
            location.real_address = name_location_join_map.text.toString()


        }

        btn_search_join_map.setOnClickListener {

            val intent = Intent(applicationContext, LocationSearchActivity::class.java)
            startActivity(intent)   // 전환될 액티비티로 넘어갈때
        }
        btn_decided_join_map.setOnClickListener {

            review_dialog.show()
//            init()
//
//            val intent = Intent(applicationContext, MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            insertUserId(user_id)
//            startActivity(intent)   // 전환될 액티비티로 넘어갈때


//            val intent = Intent(applicationContext, LoginActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//            startActivity(intent)   // 전환될 액티비티로 넘어갈때

        }
    }
    fun init(){
        Realm.init(this)
        flRealm = Realm.getDefaultInstance()
    }
    fun insertUserId(user_id:String){
        firstLoginVO = FirstLoginVO()
        firstLoginVO.user_id = user_id

        flRealm.beginTransaction()
        flRealm.copyToRealm(firstLoginVO)//memberRealm에있는 값을 복사해 넣겠다.

        flRealm.commitTransaction()
    }
    fun deleteUserId(id:String){
        val result = flRealm.where(FirstLoginVO::class.java)
                .equalTo("user_id",id)
                .findAll()

        if(result.isEmpty()){
            return
        }
        flRealm.beginTransaction() //수정을 위한
        result.deleteAllFromRealm()//네임과 일치하는걸 뺴고 렘에서 다 지운다.
        flRealm.commitTransaction()
        // Toast.makeText(this,"삭제성공", Toast.LENGTH_SHORT).show()

    }

}
