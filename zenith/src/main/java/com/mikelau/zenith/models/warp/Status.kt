package com.mikelau.zenith.models.warp


import com.google.gson.annotations.SerializedName

class Status<T> {

    var status: Int = 0
    var message: String? = null
    @SerializedName("result")
    var result: T? = null

}
