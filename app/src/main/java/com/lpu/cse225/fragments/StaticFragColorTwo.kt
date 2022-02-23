package com.lpu.cse225.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.lpu.cse225.R

class StaticFragColorTwo : Fragment() {
    private lateinit var parentContainer: LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.static_frag_color_two, container, false)
        parentContainer = view.findViewById(R.id.parentLL)
        return view
    }

    fun updateColor(color: Int) {
        parentContainer.setBackgroundColor(color)
    }

}