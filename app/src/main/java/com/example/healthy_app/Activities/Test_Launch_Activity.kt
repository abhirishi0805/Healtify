package com.example.healthy_app.Activities

import android.R.attr.bitmap
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.healthy_app.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.util.*


class Test_Launch_Activity : AppCompatActivity() {

    lateinit var  ready_text_view : TextView

    var firebaseStorage: FirebaseStorage? = null
    var storageReference: StorageReference? = null

    val ONE_MEGABYTE = (1024 * 1024).toLong()

    var bitmap_list = ArrayList<Bitmap>()
   lateinit var bitmap_one : Bitmap
   lateinit var bitmap_two : Bitmap
   lateinit var bitmap_three : Bitmap
   lateinit var bitmap_four : Bitmap
   var is_Ready  = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_test_launch)


        val window: Window = this@Test_Launch_Activity.getWindow()
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)



        firebaseStorage = FirebaseStorage.getInstance()
        storageReference = firebaseStorage!!.getReference("Astigmatism")


        ready_text_view = findViewById(R.id.ready_text_view);



        loadData();

        ready_text_view.setOnClickListener{


                var intent = Intent(this@Test_Launch_Activity ,  Test_Activity::class.java);
                startActivity(intent);
        }





    }

    private fun loadData() {

        storageReference!!.child("ast1.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener { bytes ->
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)

            bitmap_one = bitmap;
        }.addOnFailureListener { exception ->

        }



        storageReference!!.child("ast2.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener { bytes ->
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            bitmap_two = bitmap;
        }.addOnFailureListener { exception ->

        }


        storageReference!!.child("ast3.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener { bytes ->
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            bitmap_three = bitmap;
        }.addOnFailureListener { exception ->

        }



        storageReference!!.child("ast4.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener { bytes ->
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            bitmap_four = bitmap;
            is_Ready=true;
        }.addOnFailureListener { exception ->

        }


    }
}