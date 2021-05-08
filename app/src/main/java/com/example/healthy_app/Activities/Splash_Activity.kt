package com.example.healthy_app.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.healthy_app.R

class Splash_Activity : AppCompatActivity() {


    lateinit  var image_View : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_)


        val window: Window = this@Splash_Activity.getWindow()
        window.navigationBarColor = ContextCompat.getColor(
                this@Splash_Activity,
                R.color.white
        )
        window.statusBarColor= ContextCompat.getColor(
                this@Splash_Activity,
                R.color.white
        )

     image_View = findViewById(R.id.icon);

        image_View.alpha = 0f
        image_View.animate().alpha(1f).duration = 1000

        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(2500)


                    val intent = Intent(
                            this@Splash_Activity,
                            MainActivity::class.java
                    )
                    startActivity(intent)

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }
        background.start()
    }
}