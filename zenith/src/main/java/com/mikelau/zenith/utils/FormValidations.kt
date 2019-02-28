package com.mikelau.zenith.utils

import android.widget.EditText

/**
 * Created by Mike on 7/22/2016.
 * FormValidations speaks for itself, a class used for helping out or validating text fields.
 */
object FormValidations {

    // Empty field validation
    @JvmStatic
    fun isEmpty(e: EditText): Boolean {
        return e.text.toString().trim { it <= ' ' } == ""
    }

    // Validate email address format (e.g. abc@test.com)
    @JvmStatic
    fun isValidEmail(e: EditText): Boolean {
        return !e.text.toString().trim { it <= ' ' }.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$".toRegex())
    }

    // Checks if the 2 EditText given have matching values
    @JvmStatic
    fun isMatch(et1: EditText, et2: EditText): Boolean {
        return et1.text.toString() != et2.text.toString()
    }

    // Check if EditText input is greater than the length
    @JvmStatic
    fun isGreaterThan(e: EditText, length: Int): Boolean {
        return e.text.toString().length < length
    }

    // Check if the text between meets minimum and maximum
    @JvmStatic
    fun isBetween(e: EditText, min: Int, max: Int): Boolean {
        return e.text.toString().length in min..max
    }

    // Checks if the characters for a said field is valid
    @JvmStatic
    fun isValidAlphanumeric(e: EditText): Boolean {
        return e.text.toString().trim { it <= ' ' }.matches("[a-zA-Z0-9]+".toRegex())
    }

}
