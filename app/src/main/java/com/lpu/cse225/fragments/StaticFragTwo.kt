package com.lpu.cse225.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.lpu.cse225.R
import com.lpu.cse225.interfaces.OnBtnPressedListener
import java.lang.ClassCastException

class StaticFragTwo : Fragment() {

    private lateinit var buttonListener: OnBtnPressedListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.static_frag_two, container, false)
        init(v)
        return v
    }

    private fun init(v: View?) {
        v!!.findViewById<Button>(R.id.fragTwoBtn).setOnClickListener {
            buttonListener.onButtonPressed("Button Pressed in Fragment 2")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        buttonListener = try {
            activity as OnBtnPressedListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnButtonPressed")
        }
    }

    fun onFragmentInteraction(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}