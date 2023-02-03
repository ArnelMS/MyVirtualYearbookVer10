package com.example.mivyb_ver10

import android.widget.ImageView

data class Student(
    val imageNew: ImageView,
    val imageOld: ImageView,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val maidenName: String,
    val mobile: Long,
    val email: String,
    val facebookURL: String)