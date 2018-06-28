package com.mikelau.zenith.models.warp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pointer<T>() : Parcelable {

    var id: Int = 0
    var type: String? = null
        private set
    var className: String? = null
    var attributes: T? = null

    constructor(className: String, id: Int) : this() {
        this.id = id
        this.type = "Pointer"
        this.className = className
    }

    fun setType() {
        this.type = "Pointer"
    }
}
