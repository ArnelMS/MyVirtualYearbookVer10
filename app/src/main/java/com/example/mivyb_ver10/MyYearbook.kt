package com.example.mivyb_ver10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mivyb_ver10.databinding.ActivityMyYearbookBinding

class MyYearbook : AppCompatActivity() {

    lateinit var binding : ActivityMyYearbookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyYearbookBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}