package com.mikelau.zenith.models.warp

import com.google.gson.annotations.SerializedName

class Status<T> {

    @SerializedName("status") var status: Int = 0
    @SerializedName("message") var message: String? = null
    @SerializedName("result") var result: T? = null

}
