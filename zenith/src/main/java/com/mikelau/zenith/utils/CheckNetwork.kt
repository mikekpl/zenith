package com.mikelau.zenith.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object CheckNetwork {

    private var mNetwork: NetworkInfo? = null

    // Check if network is available and accessible
    fun isInternetAvailable(context: Context?): Boolean {
        try {
            mNetwork = (context
                    ?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                    .activeNetworkInfo
        } catch (e: Exception) {
            DebugLog.printStackTrace(e)
        }

        return if (mNetwork == null) {
            DebugLog.justPrint("No Internet Connection")
            false
        } else {
            if (mNetwork!!.isConnected) {
                DebugLog.justPrint("Internet Connection is Available")
                true
            } else {
                DebugLog.justPrint("No Internet Connection")
                true
            }
        }
    }

}