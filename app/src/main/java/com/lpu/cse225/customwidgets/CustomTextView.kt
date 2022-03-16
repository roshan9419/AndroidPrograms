package com.lpu.cse225.customwidgets

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.lpu.cse225.R

class CustomTextView: AppCompatTextView {
    private var title: String? = null
    private var showColor = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet): super(context, attrs) {
        val typedArr: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
        try {
            title = typedArr.getString(R.styleable.CustomTextView_setTitle)
            text = if (title == null) "Custom Message" else title
            showColor = typedArr.getBoolean(R.styleable.CustomTextView_setColor, false)
        } finally {
            typedArr.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}