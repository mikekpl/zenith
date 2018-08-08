package com.mikelau.zenith.utils

import android.support.design.widget.TextInputLayout

/**
 * Simple helper for Forms
 */
object FormHelper {

    @JvmStatic
    fun resetInputFieldError(vararg layout: TextInputLayout) {
        for(textInputLayout in layout) {
            textInputLayout.error = null
        }
    }

}
