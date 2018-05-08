package com.mikelau.zenith.widgets

import android.content.Context
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.Patterns
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView

class TextViewLinkHandler(private val mListener: OnTextViewClickMovementListener?, context: Context) : LinkMovementMethod() {

    private val mGestureDetector: GestureDetector
    private var mWidget: TextView? = null
    private var mBuffer: Spannable? = null

    enum class LinkType {

        /**
         * Indicates that phone link was clicked
         */
        PHONE,

        /**
         * Identifies that URL was clicked
         */
        WEB_URL,

        /**
         * Identifies that Email Address was clicked
         */
        EMAIL_ADDRESS,

        /**
         * Indicates that none of above mentioned were clicked
         */
        NONE
    }

    /**
     * Interface used to handle Long clicks on the [TextView] and taps
     * on the phone, web, mail links inside of [TextView].
     */
    interface OnTextViewClickMovementListener {

        /**
         * This method will be invoked when user press and hold
         * finger on the [TextView]
         *
         * @param linkText Text which contains link on which user presses.
         * @param linkType Type of the link can be one of [LinkType] enumeration
         */
        fun onLinkClicked(linkText: String, linkType: LinkType)

        /**
         * @param text Whole text of [TextView]
         */
        fun onLongClick(text: String)
    }


    init {
        mGestureDetector = GestureDetector(context, SimpleOnGestureListener())
    }

    override fun onTouchEvent(widget: TextView, buffer: Spannable, event: MotionEvent): Boolean {
        mWidget = widget
        mBuffer = buffer
        mGestureDetector.onTouchEvent(event)

        return false
    }

    /**
     * Detects various gestures and events.
     * Notify users when a particular motion event has occurred.
     */
    internal inner class SimpleOnGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(event: MotionEvent): Boolean {
            // Notified when a tap occurs.
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            // Notified when a long press occurs.
            val text = mBuffer!!.toString()

            mListener?.onLongClick(text)
        }

        override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
            // Notified when tap occurs.
            val linkText = getLinkText(mWidget!!, mBuffer!!, event)

            var linkType = LinkType.NONE

            if (Patterns.PHONE.matcher(linkText).matches()) {
                linkType = LinkType.PHONE
            } else if (Patterns.WEB_URL.matcher(linkText).matches()) {
                linkType = LinkType.WEB_URL
            } else if (Patterns.EMAIL_ADDRESS.matcher(linkText).matches()) {
                linkType = LinkType.EMAIL_ADDRESS
            }

            mListener?.onLinkClicked(linkText, linkType)

            return false
        }

        private fun getLinkText(widget: TextView, buffer: Spannable, event: MotionEvent): String {
            var x = event.x.toInt()
            var y = event.y.toInt()

            x -= widget.totalPaddingLeft
            y -= widget.totalPaddingTop

            x += widget.scrollX
            y += widget.scrollY

            val layout = widget.layout
            val line = layout.getLineForVertical(y)
            val off = layout.getOffsetForHorizontal(line, x.toFloat())

            val link = buffer.getSpans(off, off, ClickableSpan::class.java)

            if (link.isNotEmpty()) {
                return try {
                    buffer.subSequence(buffer.getSpanStart(link[0]),
                            buffer.getSpanEnd(link[0])).toString()
                } catch (e: Exception) {
                    ""
                }
            }

            return ""
        }
    }
}