package com.example.healthy_app.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import com.example.healthy_app.R


class name_age_fragment : Fragment() {



   lateinit var nxt_button : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        activity!!.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
         var view = inflater.inflate(R.layout.fragment_name_age_fragment, container, false)

//        nxt_button = view.findViewById(R.id.nxt_button);

//         nxt_button.setOnClickListener{
//             childFragmentManager.beginTransaction().replace(R.id.frame, Gender_fragment()).commit();
//         }

        return view
    }


}