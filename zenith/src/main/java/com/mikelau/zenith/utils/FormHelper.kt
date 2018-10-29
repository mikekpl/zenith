package com.mikelau.zenith.utils

import com.google.android.material.textfield.TextInputLayout

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
