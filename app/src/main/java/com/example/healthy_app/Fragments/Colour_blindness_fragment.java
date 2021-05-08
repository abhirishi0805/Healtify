package com.example.healthy_app.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthy_app.R;


public class Colour_blindness_fragment extends Fragment {

    View view;
    ImageView ivColourBlindnessQuestion;
    Button btnColourBlindness1, btnColourBlindness2, btnColourBlindness3, btnColourBlindness4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_colour_blindness_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ivColourBlindnessQuestion = view.findViewById(R.id.ivColourBlindnessQuestion);
        btnColourBlindness1 = view.findViewById(R.id.btnColourBlindness1);
        btnColourBlindness2 = view.findViewById(R.id.btnColourBlindness2);
        btnColourBlindness3 = view.findViewById(R.id.btnColourBlindness3);
        btnColourBlindness4 = view.findViewById(R.id.btnColourBlindness4);


    }
}