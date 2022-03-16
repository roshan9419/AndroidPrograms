package com.lpu.cse225

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lpu.cse225.fragments.StaticFragColorTwo
import com.lpu.cse225.interfaces.FragmentColorListener

class FragmentStaticColorActivity : AppCompatActivity(), FragmentColorListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_static_color)
    }

    fun changeColor(v: View) {
        val fragment2 = supportFragmentManager
            .findFragmentByTag("fragStaticColorTwo") as StaticFragColorTwo
        fragment2.updateColor(Color.RED)
    }

    override fun newFragmentColor(color: Int) {
        val fragment2 = supportFragmentManager
            .findFragmentByTag("fragStaticColorTwo") as StaticFragColorTwo
        fragment2.updateColor(color)
    }
}