package com.mikelau.zenith.widgets

import android.os.Build
import android.annotation.TargetApi
import android.widget.TextView
import android.content.Context
import android.util.AttributeSet

/** The TextView that doesn't scroll, but expands. **/
class NoScrollTextView : TextView {
    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {}

    override fun scrollTo(x: Int, y: Int) {
        //do nothing
    }
}