package com.mikelau.zenith.interfaces

import android.content.DialogInterface

/** Interface for Custom AlertDialog UI / Behavior **/
class AlertInterface {

    interface SingleButton {
        fun positiveMethod(dialog: DialogInterface, id: Int)
    }

    interface WithNoNeutral {
        fun positiveMethod(dialog: DialogInterface, id: Int)
        fun negativeMethod(dialog: DialogInterface, id: Int)
    }

    interface WithNeutral {
        fun positiveMethod(dialog: DialogInterface, id: Int)
        fun neutralMethod(dialog: DialogInterface, id: Int)
        fun negativeMethod(dialog: DialogInterface, id: Int)
    }

}
