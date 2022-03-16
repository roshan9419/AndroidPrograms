package com.lpu.cse225.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.lpu.cse225.FragmentsConnectionActivity
import com.lpu.cse225.R

class FragmentConnOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_conn_one, container, false)
        val et: EditText = view.findViewById(R.id.fragConnET)
        view.findViewById<Button>(R.id.fragConnBtn2nd).setOnClickListener {
            (activity as FragmentsConnectionActivity).passData(et.text.toString(), 2)
        }
        view.findViewById<Button>(R.id.fragConnBtn3rd).setOnClickListener {
            (activity as FragmentsConnectionActivity).passData(et.text.toString(), 3)
        }
        return view
    }

}