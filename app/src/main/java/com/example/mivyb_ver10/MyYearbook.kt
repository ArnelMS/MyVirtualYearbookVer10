package com.example.mivyb_ver10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mivyb_ver10.databinding.ActivityMyYearbookBinding

class MyYearbook : AppCompatActivity() {

    lateinit var binding : ActivityMyYearbookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyYearbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentList = mutableListOf<Student>(
            Student(R.drawable.dashboar_icon, 1, "Arnel", "Mendoza","Sebastian","n/a",1234568,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.add_photo, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.dashboar_icon, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.add_photo, 1, "Arnel", "Mendoza","Sebastian","n/a",974864513,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.dashboar_icon, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.add_photo, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.dashboar_icon, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.add_photo, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.dashboar_icon, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.add_photo, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.dashboar_icon, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
            Student(R.drawable.add_photo, 1, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com")
        )
        val adapter = StudentAdapter(studentList)

        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager = LinearLayoutManager(this)

    }
}