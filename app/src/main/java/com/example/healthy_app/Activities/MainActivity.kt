package com.example.healthy_app.Activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.healthy_app.Fragments.Astigmatism_fragment
import com.example.healthy_app.Fragments.Gender_fragment
import com.example.healthy_app.Fragments.name_age_fragment

import com.example.healthy_app.R

class MainActivity : AppCompatActivity() {



    lateinit var  fragment_one : Fragment
    lateinit var  fragment_two : Fragment
    lateinit var  fragment_three : Fragment
    lateinit var nxt_button : ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment_one = name_age_fragment();
        fragment_two = Gender_fragment();


        nxt_button = findViewById(R.id.nxt_button);


        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment_one).commit();

        nxt_button.setOnClickListener{

            if(fragment_one.isVisible)
            {

                supportFragmentManager.beginTransaction().replace(R.id.frame, fragment_two).commit();
            }
            else if(fragment_two.isVisible)
            {
                var intent = Intent(this@MainActivity , Test_Launch_Activity ::class.java )
                startActivity(intent)
            }


        }

    }

}