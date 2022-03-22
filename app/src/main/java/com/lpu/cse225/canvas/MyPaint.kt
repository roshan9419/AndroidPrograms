package com.lpu.cse225.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MyPaint : View {

    private lateinit var p: Paint
    private lateinit var mPath: Path
    private var backgroundCanvasColor = Color.WHITE
    private var canvasStrokeColor = Color.BLACK

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }

    private fun init() {
        p = Paint()
        mPath = Path()
        p.color = canvasStrokeColor
        p.style = Paint.Style.STROKE
        p.strokeWidth = 10f
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(backgroundCanvasColor)
        canvas.drawPath(mPath, p)
    }

    fun changeTheme(isDarkMode: Boolean) {
        if (isDarkMode) {
            backgroundCanvasColor = Color.BLACK
            canvasStrokeColor = Color.WHITE
        } else {
            backgroundCanvasColor = Color.WHITE
            canvasStrokeColor = Color.BLACK
        }
        p.color = canvasStrokeColor
        postInvalidate()
    }

    fun clear() {
        mPath.reset()
        postInvalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> mPath.moveTo(event.x, event.y)
            MotionEvent.ACTION_MOVE -> mPath.lineTo(event.x, event.y)
        }
        invalidate()
        return true
    }

}