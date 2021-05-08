package com.example.healthy_app.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthy_app.R


class name_age_fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

         var view = inflater.inflate(R.layout.fragment_name_age_fragment, container, false)



        return view
    }


}