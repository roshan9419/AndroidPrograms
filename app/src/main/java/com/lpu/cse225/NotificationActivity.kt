package com.lpu.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NotificationActivity : AppCompatActivity() {

    private lateinit var sendBtn: Button
    private lateinit var titleET: EditText
    private lateinit var bodyET: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        sendBtn = findViewById(R.id.sendBtn)
        titleET = findViewById(R.id.titleET)
        bodyET = findViewById(R.id.bodyET)

        sendBtn.setOnClickListener {
            sendNotification(titleET.text.toString(), bodyET.text.toString())
        }
    }

    private fun sendNotification(title: String, body: String) {
    }
}