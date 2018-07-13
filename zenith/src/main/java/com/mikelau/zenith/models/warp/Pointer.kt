package com.mikelau.zenith.models.warp

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pointer<T>() : Parcelable {

    @SerializedName("id") var id: Int = 0
    @SerializedName("type") var type: String? = null
        private set
    @SerializedName("className") var className: String? = null
    @SerializedName("attributes") var attributes: T? = null

    constructor(className: String, id: Int) : this() {
        this.id = id
        this.type = "Pointer"
        this.className = className
    }

    fun setType() {
        this.type = "Pointer"
    }
}
