package com.lpu.cse225.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lpu.cse225.R

class FragmentConnThree : Fragment() {

    private lateinit var outputTV: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_conn_three, container, false)
        outputTV = view.findViewById(R.id.transferDataTV)
        return view
    }

    fun updateData(msg: String) {
        outputTV.text = msg
    }
}