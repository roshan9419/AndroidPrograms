package com.lpu.cse225

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lpu.cse225.fragments.FragmentConnThree
import com.lpu.cse225.fragments.FragmentConnTwo
import com.lpu.cse225.fragments.StaticFragColorTwo
import com.lpu.cse225.interfaces.FragmentDataTransfer

class FragmentsConnectionActivity : AppCompatActivity(), FragmentDataTransfer {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_connection)
    }

    override fun passData(msg: String, fragmentNo: Int) {
        when (fragmentNo) {
            2 -> (supportFragmentManager.findFragmentByTag("fragConn2") as FragmentConnTwo).updateData(msg)
            3 -> (supportFragmentManager.findFragmentByTag("fragConn3") as FragmentConnThree).updateData(msg)
            else -> Toast.makeText(this, "Invalid fragment", Toast.LENGTH_SHORT).show()
        }
    }
}