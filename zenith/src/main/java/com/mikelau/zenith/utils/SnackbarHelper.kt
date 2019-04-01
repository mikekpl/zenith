package com.mikelau.zenith.utils

import android.app.Activity
import androidx.core.content.ContextCompat
import com.androidadvance.topsnackbar.TSnackbar
import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.mikelau.zenith.R

object SnackbarHelper {

    private fun getSnackBarConfig(
            activity: Activity, text: Any?, color: Int?,
            view: Any? = null
    ) {
        val textConfig: CharSequence = when (text) {
            is String -> text
            is Int -> activity.getString(text)
            else -> text.toString()
        }
        val viewConfig: View =
                try {
                    when (view) {
                        is View -> view
                        is Int -> activity.findViewById(view) as View
                        else -> activity.findViewById(android.R.id.content) as View
                    }
                } catch (e: Exception) {
                    activity.findViewById(android.R.id.content) as View
                }
        val sn = TSnackbar.make(viewConfig, textConfig, TSnackbar.LENGTH_LONG)
        sn.setMaxWidth(3000)
        val snView = sn.view
        val textView = snView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text) as TextView
        snView.setBackgroundColor(ContextCompat.getColor(activity, color!!))
        textView.setTextColor(Color.WHITE)
        sn.show()
    }

    private fun getColor(style: Int?): Int {
        return when (style) {
            0 -> R.color.color_red
            1 -> R.color.color_green
            else -> style!!
        }
    }

    @JvmStatic
    fun show(activity: Activity, text: Any?, style: Int?, view: Any?) {
        getSnackBarConfig(activity, text, getColor(style!!), view)
    }

    @JvmStatic
    fun show(activity: Activity, text: Any?, style: Int?) {
        getSnackBarConfig(activity, text, getColor(style!!))
    }

}
