package com.lpu.cse225.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import com.lpu.cse225.R
import kotlin.random.Random

class StaticFragOne : Fragment() {

    private lateinit var fragContainer: FrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.static_frag_one, container, false)

        fragContainer = view.findViewById(R.id.fragmentContainer)

        view.findViewById<Button>(R.id.fragOneBtn).setOnClickListener {
            fragContainer.setBackgroundColor(
                Color.argb(
                    255,
                    Random.nextInt(256),
                    Random.nextInt(256),
                    Random.nextInt(256)
                )
            )
        }

        return view
    }

}