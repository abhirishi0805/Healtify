package com.example.healthy_app.Activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.healthy_app.Fragments.Astigmatism_fragment

import com.example.healthy_app.R

class MainActivity : AppCompatActivity() {



    lateinit var  fragment : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = Astigmatism_fragment();


        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();

    }
}