package com.lpu.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import kotlin.math.ceil
import kotlin.math.floor

class RatingBarActivity : AppCompatActivity() {

    private lateinit var ratingBar1: RatingBar
    private lateinit var ratingBar2: RatingBar
    val ratingValues = arrayOf("Very Poor", "Poor", "Average", "Good", "Excellent")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)

        ratingBar1 = findViewById(R.id.ratingBar1)
        ratingBar2 = findViewById(R.id.ratingBar2)

        findViewById<Button>(R.id.submitBtn).setOnClickListener {
            Toast.makeText(
                this,
                "Thanks for giving ${ratingBar1.rating.toString() + '/' + ratingBar1.numStars.toString()}",
                Toast.LENGTH_LONG
            ).show()
        }

        ratingBar2.setOnRatingBarChangeListener { _, value, _ ->
            val index = ceil(value.toDouble()).toInt() - 1
            findViewById<TextView>(R.id.ratingValueTV).text =
                ratingValues[if (index < 0) 0 else index]
        }

        findViewById<RatingBar>(R.id.cleanlinessRating).setOnRatingBarChangeListener {_,_,_ -> updateAvgRating()}
        findViewById<RatingBar>(R.id.tasteRating).setOnRatingBarChangeListener {_,_,_ -> updateAvgRating()}
        findViewById<RatingBar>(R.id.timeRating).setOnRatingBarChangeListener {_,_,_ -> updateAvgRating()}
        findViewById<RatingBar>(R.id.otherRating).setOnRatingBarChangeListener {_,_,_ -> updateAvgRating()}

        findViewById<Button>(R.id.cardSubmitBtn).setOnClickListener { updateAvgRating() }
    }

    private fun updateAvgRating() {
        val given = findViewById<RatingBar>(R.id.cleanlinessRating).rating +
                findViewById<RatingBar>(R.id.tasteRating).rating +
                findViewById<RatingBar>(R.id.timeRating).rating +
                findViewById<RatingBar>(R.id.otherRating).rating
        val n = 5
        findViewById<RatingBar>(R.id.avgRatingBar).rating = (given / (4 * n)) * 5
        val index = ceil((given / (4 * n)) * 5).toInt() - 1
        findViewById<TextView>(R.id.avgRatingValueTV).text =
            ratingValues[if (index < 0) 0 else index]
    }
}