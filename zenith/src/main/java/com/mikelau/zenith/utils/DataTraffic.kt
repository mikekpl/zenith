package com.mikelau.zenith.utils

import android.net.TrafficStats
import android.os.Process

import java.text.DecimalFormat

class DataTraffic {

    var deviceUid = Process.myUid()
    var totalTxBytes: Long = 0
    var totalRxBytes: Long = 0

    constructor() {
        this.totalTxBytes = TrafficStats.getUidTxBytes(deviceUid)
        this.totalRxBytes = TrafficStats.getUidRxBytes(deviceUid)
    }

    constructor(totalTxBytes: Long, totalRxBytes: Long) {
        this.totalTxBytes = totalTxBytes
        this.totalRxBytes = totalRxBytes
    }

    override fun toString(): String {
        return "DataConsumption{" +
                "deviceUid=" + deviceUid +
                ", txBytes=" + getConvertedBytes(totalTxBytes) +
                ", rxBytes=" + getConvertedBytes(totalRxBytes) +
                ", total=" + getConvertedBytes(totalTxBytes + totalRxBytes) +
                '}'.toString()
    }

    companion object {

        fun getConvertedBytes(bytes: Long): String {
            if (bytes <= 0)
                return "0"
            val units = arrayOf("B", "KB", "MB", "GB", "TB")
            val digitGroups = (Math.log10(bytes.toDouble()) / Math.log10(1024.0)).toInt()
            return (DecimalFormat("#,##0.#").format(bytes / Math.pow(1024.0, digitGroups.toDouble()))
                    + " " + units[digitGroups])
        }
    }

}
