package com.lpu.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lpu.cse225.interfaces.FragmentColorListener

class FragmentStaticColorActivity : AppCompatActivity(), FragmentColorListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_static_color)
    }

    override fun newFragmentColor(color: Int) {

    }
}