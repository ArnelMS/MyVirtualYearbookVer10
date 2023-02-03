package com.example.mivyb_ver10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mivyb_ver10.databinding.ActivityMyYearbookBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class MyYearbook : AppCompatActivity() {

    lateinit var binding: ActivityMyYearbookBinding
    var dao = StudentDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyYearbookBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun view() {
        dao.get().addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var students: ArrayList<Student> = ArrayList<Student>()

                var dataFromDB = snapshot.children

                for (data in dataFromDB) {

                    // Get ID of Object from DB
                    var id = data.key.toString()

                    var imageNew = data.child("imageNew").value.toString()
                    var imageOld = data.child("imageOld").value.toString()
                    var firstName = data.child("firstName").value.toString()
                    var middleName = data.child("middleName").value.toString()
                    var lastName = data.child("lastName").value.toString()
                    var maidenName = data.child("maidenName").value.toString()
                    var mobile = data.child("mobile").value.toString()
                    var email = data.child("email").value.toString()
                    var facebookURL = data.child("facebookURL").value.toString()

                    var student = Student(
                        1,
                        2,
                        firstName,
                        middleName,
                        lastName,
                        maidenName,
                        0,
                        email,
                        facebookURL
                    )
                    students.add(student)
                }
                var adapter = StudentAdapter(students)

                binding.myRecycler.adapter = adapter
                binding.myRecycler.layoutManager = LinearLayoutManager(applicationContext)

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}

//
//    val studentList = mutableListOf<Student>(
//            Student(R.drawable.dashboar_icon, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",1234568,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.add_photo, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.dashboar_icon, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.add_photo, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",974864513,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.dashboar_icon, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.add_photo, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.dashboar_icon, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.add_photo, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.dashboar_icon, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.add_photo, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.dashboar_icon, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com"),
//            Student(R.drawable.add_photo, R.drawable.dashboar_icon, "Arnel", "Mendoza","Sebastian","n/a",97486451341,"arenlsefsd@mail.com","www.facebook.com")
//        )
//        val adapter = StudentAdapter(studentList)
//
//        binding.myRecycler.adapter = adapter
//        binding.myRecycler.layoutManager = LinearLayoutManager(this)
//
//    binding.btnRefresh.setOnClickListener(){
//        view()
//    }
//
//}