package com.example.healthy_app.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.healthy_app.Fragments.Astigmatism_fragment
import com.example.healthy_app.R

class Test_Activity : AppCompatActivity() {

    lateinit var  frame_second : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        frame_second = findViewById(R.id.frame_second);

        supportFragmentManager.beginTransaction().replace(R.id.frame_second , Astigmatism_fragment()).commit()




    }
}