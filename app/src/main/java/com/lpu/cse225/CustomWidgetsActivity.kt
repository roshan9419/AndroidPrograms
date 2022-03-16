package com.lpu.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CustomWidgetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_widgets)

        findViewById<Button>(R.id.submitBtn).setOnClickListener {
            Toast.makeText(
                this,
                findViewById<EditText>(R.id.customET).text.toString(),
                Toast.LENGTH_LONG
            )
                .show()
        }
    }
}