package com.mikelau.zenith.utils

import android.net.UrlQuerySanitizer

class CustomUrlQuerySanitizer : UrlQuerySanitizer() {
    override fun parseEntry(parameter: String, value: String) {
        val valueSanitizer = getEffectiveValueSanitizer(parameter) ?: return
        val sanitizedValue = valueSanitizer.sanitize(value)
        addSanitizedEntry(parameter, sanitizedValue)
    }
}