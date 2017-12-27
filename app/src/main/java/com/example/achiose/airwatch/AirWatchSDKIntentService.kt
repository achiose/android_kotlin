package com.example.achiose.airwatch

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.airwatch.sdk.AirWatchSDKBaseIntentService
import com.airwatch.sdk.profile.AnchorAppStatus
import com.airwatch.sdk.profile.ApplicationProfile
import com.airwatch.sdk.shareddevice.ClearReasonCode

/**
 * Created by achiose on 13/12/17.
 */
class AirWatchSDKIntentService : AirWatchSDKBaseIntentService() {

    override fun onAnchorAppUpgrade(p0: Context?, p1: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d("AirWatchTest", "onAnchorAppUpgrade")
    }

    override fun onAnchorAppStatusReceived(p0: Context?, anchorAppStatus: AnchorAppStatus?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d("AirWatchTest", "onAnchorAppStatus")
        Log.d("AirWatchTest", "onAnchorAppStatus " + anchorAppStatus?.dndStatus)
        Log.d("AirWatchTest", "onAnchorAppStatus " + anchorAppStatus?.anchorType)
        Log.d("AirWatchTest", "onAnchorAppStatus " + anchorAppStatus?.workspaceExitMode)
    }

    override fun onApplicationConfigurationChange(bundle: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d("AirWatchTest", "onApplicationConfigurationChange")
        Log.d("AirWatchTest", bundle?.keySet().toString())
    }

    override fun onClearAppDataCommandReceived(p0: Context?, p1: ClearReasonCode?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onApplicationProfileReceived(context: Context?, profileId: String?, awAppProfile: ApplicationProfile?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.d("AirWatchTest", "onApplicationProfileReceived")
        Log.d("AirWatchTest", "profileId " + profileId)
        Log.d("AirWatchTest", "ApplicationProfile " + awAppProfile?.toString())
    }
}