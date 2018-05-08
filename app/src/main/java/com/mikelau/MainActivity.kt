package com.mikelau

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mikelau.zenith.utils.CheckNetwork
import com.mikelau.zenith.utils.DebugLog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // DebugLog Test
        DebugLog.showError(this, "HELLO")
        DebugLog.showError(this, "HEY")
        DebugLog.showError(this, "HI")

        // CheckNetwork Test
        CheckNetwork.isInternetAvailable(this)

    }

}
