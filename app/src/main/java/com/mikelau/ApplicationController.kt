package com.mikelau

import android.app.Application
import com.mikelau.zenith.utils.DebugLog

class ApplicationController : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize DebugLog
        DebugLog.isProduction = false
    }

}
