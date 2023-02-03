package com.example.mivyb_ver10

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mivyb_ver10.databinding.ActivityProfileRegistrationBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener

class ProfileRegistrationActivity : AppCompatActivity() {

    var dao = StudentDao()
    lateinit var binding: ActivityProfileRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddProfile.setOnClickListener() {
            dao.add(Student(
                    1, 2,
                    "Arnel",
                    "Mendoza",
                    "Sebastian",
                    "n/a",
                    123459,
                    "user1@email.com",
                    "www.facebook.com.Arnel"))
            Toast.makeText(applicationContext, "Success!", Toast.LENGTH_SHORT).show()
        }

        binding.btnLoad.setOnClickListener() {
                val intent = Intent(this, MyYearbook::class.java)
                startActivity(intent)
            view()
        }

        binding.btnUpdate.setOnClickListener(){
            updateData()
        }
        binding.btnDeleteProfile.setOnClickListener(){
            deleteData()
        }
        binding.imgProfileNew.setOnClickListener(){
            showCamera()
        }
        binding.imgGradPic.setOnClickListener(){
            showCamera()
        }
        binding.btnAddGallery.setOnClickListener(){
            showGallery()
        }

    }
// GALLERY LAUNCHER
    private fun showGallery(){
        Dexter.withContext(this).withPermission(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object:PermissionListener{
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                galleryLauncher.launch(galleryIntent)
                Toast.makeText(applicationContext, "GALLERY PERMISSION OK!", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "GALLERY PERMISSION DENIED", Toast.LENGTH_SHORT).show()
                gotoSettings()

            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

        }).onSameThread().check()

    }
// CAMERA LAUNCHER
    private fun showCamera() {
        Dexter.withContext(this).withPermission(
            Manifest.permission.CAMERA
        ).withListener(object : PermissionListener{
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(cameraIntent)
                cameraLauncher.launch(cameraIntent)
                Toast.makeText(applicationContext, "Camera Granted!", Toast.LENGTH_SHORT).show()
                gotoSettings()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                Toast.makeText(applicationContext, "Camera Denied", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionRationaleShouldBeShown(
                request: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }
        }).onSameThread().check()
    }

    private fun gotoSettings() {
        AlertDialog.Builder(this).setMessage("It seems your permission has been denied. Got to settings")
            .setPositiveButton("Go to Settings"){dialog, item ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                var uri = Uri.fromParts("package",packageName, null)
                intent.data = uri
                startActivity(intent)
            }.setNegativeButton("Cancel"){dialog, item->
                dialog.dismiss()
            }.show()
    }

    val cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
        if (result.resultCode == Activity.RESULT_OK){
            result.data?.extras.let{
                val image : Bitmap = result.data?.extras?.get("data") as Bitmap
                binding.imgProfileNew.setImageBitmap(image)
            }
        }
    }
    val galleryLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
        if (result.resultCode == Activity.RESULT_OK){
            result.data?.let{
                val selectedImage = result.data?.data
                binding.imgGradPic.setImageURI(selectedImage)
            }
        }
    }



    private fun deleteData() {
        dao.remove("-NNHtXcN04nN9t2s-oCm")
    }

    private fun updateData() {
        var mapData = mutableMapOf<String, String>()
        mapData["firstName"] = "ARNEL"
        dao.update("-NNHtXcN04nN9t2s-oCm",mapData)
    }

    private fun view() {
        dao.get().addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var students : ArrayList<Student> = ArrayList<Student>()

                var dataFromDb = snapshot.children
//                Toast.makeText(applicationContext, ""+dataFromDb, Toast.LENGTH_SHORT).show()

                for(data in dataFromDb){
                    var imageProfile = data.child("ProfilePhoto").value.toString()
                    var imageOld = data.child("OldPhoto").value.toString()
                    var firstName = data.child("FirstName").value.toString()
                    var middleName = data.child("MiddleName").value.toString()
                    var maidenName = data.child("MaidenName").value.toString()
                    var lastName = data.child("LastName").value.toString()
                    var mobile = data.child("Mobile").value.toString()
                    var email = data.child("Email").value.toString()
                    var facebookUrl = data.child("FacebookURL").value.toString()


                    //get id of object from DB
                    var id = data.key.toString()
                    var student = Student(
                        0,
                        0,
                        "firstName",
                        "middleName",
                        "Sebastian",
                        "n/a",
                        123456789,
                        "user1@email.com",
                        "arnelmsebastian")
                    students.add(student)


                    Toast.makeText(applicationContext, ""+id, Toast.LENGTH_SHORT).show()
                    Toast.makeText(applicationContext, ""+student, Toast.LENGTH_SHORT).show()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}