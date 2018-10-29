package com.mikelau.zenith.utils

import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FloatPropertyCompat
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import android.view.View

class AnimatorHelper {

    companion object {
        fun startSpringAnimation(view: View) {
            startSpringAnimation(view, 0.35f)
        }

        fun startSpringAnimation(view: View, dampingRatio: Float) {
            val scale = object : FloatPropertyCompat<View>("") {

                override fun getValue(view: View): Float {
                    return view.scaleX
                }

                override fun setValue(view: View, value: Float) {
                    view.scaleX = value
                    view.scaleY = value
                }
            }

            val anim = SpringAnimation(view, scale, 1f)
            anim.spring
                    .setStiffness(SpringForce.STIFFNESS_LOW).dampingRatio = dampingRatio
            anim.setMinimumVisibleChange(DynamicAnimation.MIN_VISIBLE_CHANGE_SCALE)
                    .setStartVelocity(10f)
                    .start()
        }
    }
}
