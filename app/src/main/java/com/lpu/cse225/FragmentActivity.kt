package com.lpu.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lpu.cse225.fragments.StaticFragTwo
import com.lpu.cse225.interfaces.OnBtnPressedListener

class FragmentActivity : AppCompatActivity(), OnBtnPressedListener {

//    https://github.com/sudha-shanker/CSE225-KOTLIN-FRAGMENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }

    override fun onButtonPressed(msg: String) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        val obj = supportFragmentManager.findFragmentById(R.id.fragment2) as StaticFragTwo
        obj.onFragmentInteraction(msg)
    }
}