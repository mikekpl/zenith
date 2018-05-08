package com.mikelau.zenith.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

object CheckNetwork {

    private var mNetwork: NetworkInfo? = null

    // Check if network is available and accessible
    fun isInternetAvailable(context: Context): Boolean {
        try {
            mNetwork = (context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
                    .activeNetworkInfo
        } catch (e: Exception) {
            DebugLog.showError(context, "Check Network: " + e.message)
        }

        return if (mNetwork == null) {
            DebugLog.showError(context, "Network Connection Not Available")
            false
        } else {
            if (mNetwork!!.isConnected) {
                DebugLog.showError(context, "Network Connection Available")
                true
            } else {
                DebugLog.showError(context, "Network Connection Not Available")
                true
            }
        }
    }

}