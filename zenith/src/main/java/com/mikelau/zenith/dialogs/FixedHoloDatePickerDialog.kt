package com.mikelau.zenith.dialogs

import android.app.DatePickerDialog
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.DatePicker
import com.mikelau.zenith.utils.DebugLog
import java.lang.reflect.Field

/** Enforce Holo Date Picker Dialog **/
class FixedHoloDatePickerDialog(context: Context, callBack: DatePickerDialog.OnDateSetListener, year: Int, monthOfYear: Int, dayOfMonth: Int) : DatePickerDialog(context, callBack, year, monthOfYear, dayOfMonth) {

    init {
        // Force spinners on Android 7.0 only (SDK 24).
        // Note: I'm using a naked SDK value of 24 here, because I'm
        // targeting SDK 23, and Build.VERSION_CODES.N is not available yet.
        // But if you target SDK >= 24, you should have it.
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                val field = this.findField(DatePickerDialog::class.java, DatePicker::class.java, "mDatePicker")
                val datePicker = field!!.get(this) as DatePicker
                val delegateClass = Class.forName("android.widget.DatePicker\$DatePickerDelegate")
                val delegateField = this.findField(DatePicker::class.java, delegateClass, "mDelegate")

                val delegate = delegateField!!.get(datePicker)
                val spinnerDelegateClass = Class.forName("android.widget.DatePickerSpinnerDelegate")

                if (delegate.javaClass != spinnerDelegateClass) {
                    delegateField.set(datePicker, null)
                    datePicker.removeAllViews()

                    val spinnerDelegateConstructor = spinnerDelegateClass.getDeclaredConstructor(
                            DatePicker::class.java, Context::class.java, AttributeSet::class.java, Int::class.javaPrimitiveType, Int::class.javaPrimitiveType)
                    spinnerDelegateConstructor.isAccessible = true

                    val spinnerDelegate = spinnerDelegateConstructor.newInstance(datePicker,
                            context, null, android.R.attr.datePickerStyle, 0)
                    delegateField.set(datePicker, spinnerDelegate)

                    datePicker.init(year, monthOfYear, dayOfMonth, this)
                    datePicker.calendarViewShown = false
                    datePicker.spinnersShown = true
                }
            } catch (e: Exception) {
                DebugLog.printStackTrace(e)
            }
        }
    }

    /**
     * Find Field with expectedName in objectClass. If not found, find first occurrence of
     * target fieldClass in objectClass.
     */
    private fun findField(objectClass: Class<*>, fieldClass: Class<*>, expectedName: String): Field? {
        try {
            val field = objectClass.getDeclaredField(expectedName)
            field.isAccessible = true
            return field
        } catch (e: NoSuchFieldException) {
            DebugLog.printStackTrace(e)
        }

        // Search for it if it wasn't found under the expectedName.
        for (field in objectClass.declaredFields) {
            if (field.type == fieldClass) {
                field.isAccessible = true
                return field
            }
        }

        return null
    }
}
