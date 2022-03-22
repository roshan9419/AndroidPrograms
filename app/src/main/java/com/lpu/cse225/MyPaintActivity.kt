package com.lpu.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat
import com.lpu.cse225.canvas.MyPaint

class MyPaintActivity : AppCompatActivity() {
    private lateinit var myPaint: MyPaint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_paint)

        myPaint = findViewById(R.id.paintContainer)

        findViewById<Button>(R.id.clearBtn).setOnClickListener {
            myPaint.clear()
        }

        findViewById<SwitchCompat>(R.id.themeSwitcher).setOnCheckedChangeListener { _, isChecked ->
            myPaint.changeTheme(isChecked)
        }
    }
}