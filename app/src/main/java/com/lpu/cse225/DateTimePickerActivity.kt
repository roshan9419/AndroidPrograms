package com.lpu.cse225

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class DateTimePickerActivity : AppCompatActivity() {
    private lateinit var chooseDateBtn: Button
    private lateinit var chooseTimeBtn: Button
    private lateinit var dateLbl: TextView
    private lateinit var timeLbl: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time_picker)

        chooseDateBtn = findViewById(R.id.pickDateBtn)
        chooseTimeBtn = findViewById(R.id.pickTimeBtn)
        dateLbl = findViewById(R.id.dateTV)
        timeLbl = findViewById(R.id.timeTV)

        setDefaultDateTime()

        chooseDateBtn.setOnClickListener {
            openDatePicker()
        }
        chooseTimeBtn.setOnClickListener {
            openTimePicker()
        }
    }

    private fun setDefaultDateTime() {
        val c = Calendar.getInstance()
        updateDate(c[Calendar.YEAR], c[Calendar.MONTH], c[Calendar.DAY_OF_MONTH])
        updateTime(c[Calendar.HOUR_OF_DAY], c[Calendar.MINUTE])
    }

    private fun openDatePicker() {
        val c = Calendar.getInstance()
        val mYear = c[Calendar.YEAR]
        val mMonth = c[Calendar.MONTH]
        val mDay = c[Calendar.DAY_OF_MONTH]

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            DatePickerDialog(this, { _, year, monthOfYear, dayOfMonth ->
                updateDate(year, monthOfYear, dayOfMonth)
            }, mYear, mMonth, mDay).show()
        }
    }

    private fun openTimePicker() {
        val c = Calendar.getInstance()
        val mHr = c[Calendar.HOUR_OF_DAY]
        val mMin = c[Calendar.MINUTE]

        TimePickerDialog(this, { _, hourOfDay, minute ->
            updateTime(hourOfDay, minute)
        }, mHr, mMin, false).show()
    }

    private fun updateDate(year: Int, month: Int, day: Int) {
        dateLbl.text = "$year-$month-$day"
    }

    private fun updateTime(hr: Int, min: Int) {
        var hour = hr
        val AM_PM = if (hour < 12) "AM" else "PM"
        if (AM_PM == "PM") hour -= 12
        if (hour == 0) hour += 12
        if (min < 10) timeLbl.text = "$hour:0$min $AM_PM"
        else timeLbl.text = "$hour:$min $AM_PM"
    }
}