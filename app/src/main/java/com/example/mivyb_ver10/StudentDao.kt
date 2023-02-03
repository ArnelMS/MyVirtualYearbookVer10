package com.example.mivyb_ver10

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Query
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class StudentDao {
    var dbReference: DatabaseReference = Firebase.database.reference

    fun add(student: Student) {
        dbReference.push().setValue(student)
    }

    fun get(): Query {
        return dbReference.orderByKey()
    }

    fun remove(key:String){
        dbReference.child(key).removeValue()
    }

    fun update(key:String, map: Map<String,String>){
        dbReference.child(key).updateChildren(map)
    }

}