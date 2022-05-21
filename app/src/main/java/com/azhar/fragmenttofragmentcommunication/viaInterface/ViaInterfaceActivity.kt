package com.azhar.fragmenttofragmentcommunication.viaInterface

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.azhar.fragmenttofragmentcommunication.R
import com.azhar.fragmenttofragmentcommunication.databinding.ActivityViaInterfaceBinding


class ViaInterfaceActivity : AppCompatActivity() ,  FragmentA.FragmentAListener, FragmentB.FragmentBListener  {
    lateinit var binding: ActivityViaInterfaceBinding
    lateinit var fragmentA: FragmentA
    lateinit var fragmentB: FragmentB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViaInterfaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentA = FragmentA()
        fragmentB = FragmentB()

//        supportFragmentManager.beginTransaction()
//            .replace(binding.containerA, fragmentA)
//            .replace(binding.containerB, fragmentB)
//            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_a, fragmentA)
            .replace(R.id.container_b, fragmentB)
            .commit()
    }

    override fun onInputASent(input: CharSequence?) {
        fragmentB.updateEditText(input)
    }

    override fun onInputBSent(input: CharSequence?) {
        fragmentA.updateEditText(input)
    }
}


