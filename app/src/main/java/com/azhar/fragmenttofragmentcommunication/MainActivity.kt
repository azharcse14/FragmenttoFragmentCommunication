package com.azhar.fragmenttofragmentcommunication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azhar.fragmenttofragmentcommunication.databinding.ActivityMainBinding
import com.azhar.fragmenttofragmentcommunication.viaInterface.ViaInterfaceActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.interfaceBtnId.setOnClickListener {
            startActivity(Intent(this, ViaInterfaceActivity::class.java))
        }
    }
}