package com.example.healthy_app.Activities

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.healthy_app.R
import com.mackhartley.roundedprogressbar.RoundedProgressBar
import org.w3c.dom.Text

class Profile_Activity : AppCompatActivity() {


    var badges_text: TextView? = null
    var coins_text: TextView? = null
    lateinit var  result_text : TextView;

    lateinit var progress_bar_result : RoundedProgressBar

    lateinit var whatsapp_icon : LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        badges_text = findViewById<TextView>(R.id.badges_text)
        coins_text = findViewById<TextView>(R.id.coins_text)
        result_text = findViewById(R.id.result_text);

        progress_bar_result = findViewById(R.id.progress_bar_result)

        var  coins_no =  intent.getIntExtra("coins" , 0).toString();
        var  badges = intent.getIntExtra("badges" , 0).toString();

        if (intent.getIntExtra("coins" , 0)== 1) {
            progress_bar_result.setProgressPercentage(25.0, false)
            result_text.setText(("You Scored 25 % in your Astigmatism Test"))
        } else if (intent.getIntExtra("coins" , 0) == 2) {
            result_text.setText(("You Scored 50 % in your Astigmatism Test"))
            progress_bar_result.setProgressPercentage(50.0, false)
        } else if (intent.getIntExtra("coins" , 0) == 3) {
            result_text.setText(("You Scored 75 % in your Astigmatism Test"))
            progress_bar_result.setProgressPercentage(75.0, false)
        } else if (intent.getIntExtra("coins" , 0) == 4) {
            result_text.setText(("You Scored 100 % in your Astigmatism Test"))
            progress_bar_result.setProgressPercentage(100.0, false)
        }

        whatsapp_icon = findViewById(R.id.whatsapp_icon);

        whatsapp_icon.setOnClickListener{

            val whatsappIntent = Intent(Intent.ACTION_SEND)
            whatsappIntent.type = "text/plain"
            whatsappIntent.setPackage("com.whatsapp")
            whatsappIntent.putExtra(
                Intent.EXTRA_TEXT,
                "I  am awarded  ${coins_no} coins and ${badges}  badges  in Healthify App , Come join me in the initiative"
            )
            try {
                startActivity(whatsappIntent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this@Profile_Activity, "Feature Unsupported", Toast.LENGTH_SHORT).show()
            }
        }







        coins_text!!.setText(coins_no)
        badges_text!!.setText(badges)
    }
}