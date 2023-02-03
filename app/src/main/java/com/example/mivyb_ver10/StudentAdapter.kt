package com.example.mivyb_ver10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mivyb_ver10.databinding.ActivityMainBinding
import com.example.mivyb_ver10.databinding.RowItemStudentsBinding

class StudentAdapter(val studentModel: MutableList<Student>):RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    inner class StudentViewHolder(var binding: RowItemStudentsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowItemStudentsBinding.inflate(layoutInflater,parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.binding.apply {
             if(studentModel[position].imageNew == "") {
                imgProfile.setImageResource(R.drawable.profile_modern)
            }
            if(studentModel[position].imageOld == "") {
                imgGradPic.setImageResource(R.drawable.profile_gradpic)
            }
            tvFirstName.text = studentModel[position].firstName
            tvFirstName.text = studentModel[position].firstName
            tvMiddleName.text = studentModel[position].middleName
            tvLastName.text = studentModel[position].lastName
            tvMaidenName.text = studentModel[position].maidenName
//            tvMobile.text = studentModel[position].mobile
            tvEmail.text = studentModel[position].email
            tvFacebookURL2.text = studentModel[position].facebookURL
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
        return studentModel.size
    }

}