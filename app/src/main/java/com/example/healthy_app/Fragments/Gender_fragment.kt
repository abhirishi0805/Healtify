package com.example.healthy_app.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.healthy_app.R


class Gender_fragment : Fragment() {



    lateinit var relative_woman : RelativeLayout
    lateinit var relative_man : RelativeLayout

    var selected_gender ="";


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_gender_fragment, container, false)


        relative_man = view.findViewById(R.id.relative_man)
        relative_woman = view.findViewById(R.id.relative_woman)

        relative_man.setOnClickListener{

            if(selected_gender!= "m" )
            {
                selected_gender = "m";
                relative_man.background = ContextCompat.getDrawable(context!!, R.drawable.background_gender_selected)
                relative_woman.background = ContextCompat.getDrawable(context!!, R.drawable.drawable_gender_unselected)



            }
            else
            {
                relative_man.background = ContextCompat.getDrawable(context!!, R.drawable.drawable_gender_unselected)

            }
        }

        relative_woman.setOnClickListener{

            if(selected_gender != "f")
            {

                selected_gender = "f"
                relative_woman.background = ContextCompat.getDrawable(context!!, R.drawable.background_gender_selected)
                relative_man.background = ContextCompat.getDrawable(context!!, R.drawable.drawable_gender_unselected)

            }
            else
            {
                relative_man.background = ContextCompat.getDrawable(context!!, R.drawable.drawable_gender_unselected)
            }

        }





        return view;
    }


}