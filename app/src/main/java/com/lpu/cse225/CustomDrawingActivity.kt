package com.lpu.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lpu.cse225.canvas.Shapes

class CustomDrawingActivity : AppCompatActivity() {
    lateinit var customShapes: Shapes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_drawing)

        customShapes = Shapes(this)
        setContentView(customShapes)
    }
}