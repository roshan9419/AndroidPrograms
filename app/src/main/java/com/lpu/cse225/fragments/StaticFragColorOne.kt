package com.lpu.cse225.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.lpu.cse225.FragmentStaticColorActivity
import com.lpu.cse225.R

class StaticFragColorOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.static_frag_color_one, container, false)
        view.findViewById<Button>(R.id.fragBtnGreen).setOnClickListener {
            //(activity as FragmentStaticColorActivity).newColor(Color.GREEN)
        }
        return view
    }

}