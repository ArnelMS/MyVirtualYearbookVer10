package com.example.mivyb_ver10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mivyb_ver10.databinding.ActivityMainBinding
import com.example.mivyb_ver10.databinding.RowItemStudentsBinding

class StudentAdapter(val students: MutableList<Student>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    inner class StudentViewHolder(var binding: RowItemStudentsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowItemStudentsBinding.inflate(layoutInflater,parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.apply {
            imgProfile.setImageResource(students[position].imageNew)
            imgGradPic.setImageResource(students[position].imageOld)
            tvFirstName.text = students[position].firstName
            tvFirstName.text = students[position].firstName
            tvMiddleName.text = students[position].middleName
            tvLastName.text = students[position].lastName
            tvMaidenName.text = students[position].maidenName
            tvMobile.text = students[position].toString()
            tvEmail.text = students[position].email
            tvFacebookURL2.text = students[position].facebookURL
        return

//            btnDelete.setOnClickListener() {
//                onItemDelete?.invoke(employeeModel[position],position)
//            }
//            btnEdit.setOnClickListener() {
//                onUpdate?.invoke(employeeModel[position],position)
//            }
        }

    }
    override fun getItemCount(): Int {
        return students.size
    }

}