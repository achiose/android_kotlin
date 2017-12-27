package com.example.achiose.airwatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.airwatch.sdk.AirWatchSDKException
import com.airwatch.sdk.SDKManager

class MainActivity : AppCompatActivity() {

    var sdkManager : SDKManager? = null
    var serviceError : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        Log.d("AirWatchTest", "onStatus")
        Thread (
            Runnable {
                try {
                    sdkManager = SDKManager.init(applicationContext)
                    sdkManager?.let {
                        Log.d("AirWatchTest", it.serverName)
                        Log.d("AirWatchTest", it.isEnrolled.toString())
                        Log.d("AirWatchTest", it.applicationProfile.toString())
                        Log.d("AirWatchTest", it.apiVersion.toString())
                        Log.d("AirWatchTest", it.deviceUid)
                        Log.d("AirWatchTest", it.groupId)
                        Log.d("AirWatchTest", it.apiVersion.toString())
                        Log.d("AirWatchTest", it.toString())
                    }
                } catch (e : AirWatchSDKException){
                    serviceError = true
                    Log.d("AirWatchTest", "exception " + e)
                    runOnUiThread({
                        var reason = "Air Watch SDK Connection Problem. Please make sure AirWatch MDM Agent is installed. " + e.toString()
                        Toast.makeText(applicationContext, reason, Toast.LENGTH_LONG).show()
                    })
                }
            }
        ).start()
    }
}
