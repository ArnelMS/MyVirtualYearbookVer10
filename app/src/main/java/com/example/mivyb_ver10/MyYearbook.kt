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

        view()
    }

    private fun view() {
        dao.get().addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var students: ArrayList<Student> = ArrayList<Student>()

                var dataFromDb = snapshot.children
//                Toast.makeText(applicationContext, ""+dataFromDb, Toast.LENGTH_SHORT).show()

                for (data in dataFromDb) {
                    var id = data.key.toString()
                    var imageProfile = data.child("imageNew").value.toString()
                    var imageOld = data.child("imageOld").value.toString()
                    var firstName = data.child("firstName").value.toString()
                    var middleName = data.child("middleName").value.toString()
                    var maidenName = data.child("maidenName").value.toString()
                    var lastName = data.child("lastName").value.toString()
                    var mobile = data.child("mobile").value.toString()
                    var email = data.child("email").value.toString()
                    var facebookUrl = data.child("facebookURL").value.toString()

                    var student = Student(
                        imageProfile,
                        imageOld,
                        firstName,
                        middleName,
                        lastName,
                        maidenName,
                        mobile,
                        email,
                        facebookUrl
                    )
                    students.add(student)

                }

                val adapter = StudentAdapter(students)
                binding.myRecycler.adapter = adapter
                binding.myRecycler.layoutManager = LinearLayoutManager(applicationContext)

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        )
    }private fun updateData(name : String, salary : String, id : String) {
        var mapData = mutableMapOf<String,String>()
        mapData["name"] = name
        mapData["salary"] = salary
        dao.update(id,mapData)
    }
}