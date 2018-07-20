package com.mikelau.zenith.utils

import android.content.Context
import android.util.Log

/**
 * Simple logger for checking, testing and monitoring (only enabled in non-production build)
 */
object DebugLog {

    @JvmField
    var isProduction: Boolean = true

    /**
     * Logger to just print
     * @param msg Current message to log
     */
    @JvmStatic
    fun justPrint(msg: String) {
        if (!isProduction) Log.e(":: DebugLog.class ::", msg)
    }

    /**
     * Logger to print any message in error for testing
     * @param con Current context
     * @param msg Current message to log
     */
    @JvmStatic
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
    @JvmStatic
    fun showException(con: Context?, s: Class<*>?, ex: Throwable) {
        if (!isProduction) {
            try {
                when {
                    con != null -> Log.e(":: " + con.javaClass.simpleName + ".class ::", "\n", ex)
                    s != null -> Log.e(":: " + s.simpleName + ".class ::", "\n", ex)
                    else -> Log.e(":: DebugLog.class ::", "\n", ex)
                }
            } catch (e: Exception) {
                Log.e(":: DebugLog.class ::", "\n", e)
            }
        }
    }

    /**
     * Use this instead of e.printStackTrace so we can seal our logs
     * @param e Exception in try / catch block
     */
    @JvmStatic
    fun printStackTrace(e: Exception) {
        if (!isProduction) {
            Log.e(":: Exception ::", e.message, e)
        }
    }

}
