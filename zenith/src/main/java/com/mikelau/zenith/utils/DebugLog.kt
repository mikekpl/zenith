package com.mikelau.zenith.utils


import android.content.Context
import android.util.Log

/**
 * Created by Mike on 7/26/2016.
 *
 * Simple logger for checking, testing and monitoring (only enabled in non-production build)
 */
object DebugLog {

    var isProduction: Boolean = false
    /**
     * Logger to print any message in error for testing
     * @param con Current context
     * @param msg Current message to log
     */
    fun showError(con: Context?, msg: String) {
        if (!isProduction) {
            try {
                if (con != null)
                    Log.e(":: " + con.javaClass.simpleName + ".class ::", msg)
                else
                    Log.e(":: " + "Unknown class ::", msg)
            } catch (e: Exception) {
                Log.e(":: DebugLog.class ::", "\n", e)
            }

        }
    }

    /**
     * Logger to print exception messages for testing in any environments.
     * @param con Current context
     * @param s Current class where this method is called
     * @param ex Exception value retrieved from catch
     */
    fun showException(con: Context?, s: Class<*>?, ex: Throwable) {
        if (!isProduction) {
            try {
                if (con != null)
                    Log.e(":: " + con.javaClass.simpleName + ".class ::", "\n", ex)
                else if (s != null)
                    Log.e(":: " + s.simpleName + ".class ::", "\n", ex)
                else
                    Log.e(":: DebugLog.class ::", "\n", ex)
            } catch (e: Exception) {
                Log.e(":: DebugLog.class ::", "\n", e)
            }

        }
    }

    /**
     * Use this instead of e.printStackTrace so we can seal our logs
     * @param e Exception in try / catch block
     */
    fun printStackTrace(e: Exception) {
        if (!isProduction) {
            Log.e(":: Exception ::", e.message, e)
        }
    }

}
