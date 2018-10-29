package com.mikelau.zenith.dialogs

import android.content.Context
import android.os.Build
import androidx.annotation.StringRes
import com.mikelau.zenith.R

/** Ready to use progress dialog with custom implementation. Uniformed way of making a progress dialog **/
object ProgressDialogHelper {

    private var progressDialog: android.app.ProgressDialog? = null

    @JvmStatic
    fun showProgress(context: Context, text: String, cancelable: Boolean?, touchOutside: Boolean?) {
        progressDialog = if (Build.VERSION.SDK_INT >= 23) {
            android.app.ProgressDialog(context, R.style.AppCompatAlertDialogStyle)
        } else {
            android.app.ProgressDialog(context)
        }
        progressDialog?.setMessage(text)
        progressDialog?.isIndeterminate = false
        progressDialog?.setCancelable(cancelable!!)
        progressDialog?.setCanceledOnTouchOutside(touchOutside!!)
        progressDialog?.show()
    }

    @JvmStatic
    fun showProgress(context: Context, @StringRes text: Int, cancelable: Boolean?, touchOutside: Boolean?) {
        progressDialog = if (Build.VERSION.SDK_INT >= 23) {
            android.app.ProgressDialog(context, R.style.AppCompatAlertDialogStyle)
        } else {
            android.app.ProgressDialog(context)
        }
        progressDialog?.setMessage(context.resources.getString(text))
        progressDialog?.isIndeterminate = false
        progressDialog?.setCancelable(cancelable!!)
        progressDialog?.setCanceledOnTouchOutside(touchOutside!!)
        progressDialog?.show()
    }

    @JvmStatic
    fun hideProgress() {
        if (progressDialog != null && progressDialog?.isShowing!!)
            progressDialog?.dismiss()
    }

}