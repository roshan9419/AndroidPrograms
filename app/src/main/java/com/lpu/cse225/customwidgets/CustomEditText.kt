package com.lpu.cse225.customwidgets

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat
import com.lpu.cse225.R

class CustomEditText(context: Context, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {
    private var hint: String? = null
    private var setColor = false

    private var darkButton: Drawable? = null
    private var lightButton: Drawable? = null

    private fun init() {
        darkButton = ResourcesCompat.getDrawable(resources, R.drawable.ic_clear_black, null)
        lightButton = ResourcesCompat.getDrawable(resources, R.drawable.ic_clear_light, null)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                showButton()
                show()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    @SuppressLint("ClickableViewAccessibility")
    fun show() {
        setOnTouchListener { _, motionEvent ->
            var isClicked = false
            val clearButtonStart = (width - paddingEnd - darkButton!!.intrinsicWidth).toFloat()
            if (motionEvent.x > clearButtonStart) {
                isClicked = true
            }
            if (isClicked) {
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> text!!.clear()
                    MotionEvent.ACTION_UP -> hideButton()
                }
            }
            true
        }
    }

    private fun showButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, lightButton, null)
    }

    private fun hideButton() {
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, darkButton, null)
    }

    init {
        val typedArr: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText)
        try {
            hint = typedArr.getString(R.styleable.CustomEditText_hint)
            setHint(if (hint == null) "Enter your message here..." else hint)
            setColor = typedArr.getBoolean(R.styleable.CustomEditText_setColorHint, false)

            if (setColor)
                setTextColor(Color.RED)
        } finally {
            typedArr.recycle()
            init()
        }
    }

}