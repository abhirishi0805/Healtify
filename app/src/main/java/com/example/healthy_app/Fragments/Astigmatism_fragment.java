package com.example.healthy_app.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.healthy_app.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class Astigmatism_fragment extends Fragment {

    View view;
    ImageView ivAstigmatismQuestion;
    TextView tvAstigmatismQuestion;
    Button btnAstigmatism1, btnAstigmatism2, btnAstigmatism3, btnAstigmatism4;

    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    int questionNumber;
    int answerStatus[] = {0, 0, 0, 0};      // 0 -> answered wrong,     1 -> answered correctly

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_astigmatism_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ivAstigmatismQuestion = view.findViewById(R.id.ivAstigmatismQuestion);
        tvAstigmatismQuestion = view.findViewById(R.id.tvAstigmatismQuestion);
        btnAstigmatism1 = view.findViewById(R.id.btnAstigmatism1);
        btnAstigmatism2 = view.findViewById(R.id.btnAstigmatism2);
        btnAstigmatism3 = view.findViewById(R.id.btnAstigmatism3);
        btnAstigmatism4 = view.findViewById(R.id.btnAstigmatism4);

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference("Astigmatism");

        questionNumber = 1;

        loadData(questionNumber);

        btnAstigmatism1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (questionNumber){
                    case 1:
                        answerStatus[questionNumber-1] = 0;
                        break;

                    case 2:
                        answerStatus[questionNumber-1] = 0;
                        break;

                    case 3:
                        answerStatus[questionNumber-1] = 0;
                        break;

                    case 4:
                        answerStatus[questionNumber-1] = 1;
                        // change the activity here

                        break;
                }

                questionNumber++;
                loadData(questionNumber);
            }
        });


        btnAstigmatism2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (questionNumber){
                    case 1:
                        answerStatus[questionNumber-1] = 0;
                        break;

                    case 2:
                        answerStatus[questionNumber-1] = 0;
                        break;

                    case 3:
                        answerStatus[questionNumber-1] = 0;
                        break;

                    case 4:
                        answerStatus[questionNumber-1] = 0;
                        //change the activity here

                        break;
                }

                questionNumber++;
                loadData(questionNumber);
            }
        });


        btnAstigmatism3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (questionNumber){

                    case 1:
                        answerStatus[questionNumber-1] = 1;
                        break;

                    case 2:
                        answerStatus[questionNumber-1] = 0;
                        break;

                    case 3:
                        answerStatus[questionNumber-1] = 1;
                        break;

                    case 4:
                        answerStatus[questionNumber-1] = 0;
                        //change the activity here

                        break;
                }

                questionNumber++;
                loadData(questionNumber);
            }
        });


        btnAstigmatism4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (questionNumber){

                    case 1:
                        answerStatus[questionNumber-1] = 0;
                        break;

                    case 2:
                        answerStatus[questionNumber-1] = 1;
                        break;

                    case 3:
                        answerStatus[questionNumber-1] = 0;
                        break;

                    case 4:
                        answerStatus[questionNumber-1] = 0;
                        //change the activity here

                        break;
                }

                questionNumber++;
                loadData(questionNumber);
            }
        });


    }

    private void loadData(int questionNumber)
    {
        switch (questionNumber){

            case 1:
                storageReference = storageReference.child("ast1.jpg");
                Glide.with(this)
                        .load(storageReference)
                        .into(ivAstigmatismQuestion);

                tvAstigmatismQuestion.setText("How many lines are present here?");
                btnAstigmatism1.setText("24");
                btnAstigmatism2.setText("30");
                btnAstigmatism3.setText("36");
                btnAstigmatism4.setText("12");
                break;

            case 2:
                storageReference = storageReference.child("ast2.jpg");
                Glide.with(this)
                        .load(storageReference)
                        .into(ivAstigmatismQuestion);

                tvAstigmatismQuestion.setText("How many lines are light grey shaded?");
                btnAstigmatism1.setText("24");
                btnAstigmatism2.setText("4");
                btnAstigmatism3.setText("36");
                btnAstigmatism4.setText("12");
                break;

            case 3:
                storageReference = storageReference.child("ast3.jpg");
                Glide.with(this)
                        .load(storageReference)
                        .into(ivAstigmatismQuestion);

                tvAstigmatismQuestion.setText("What number do you see here?");
                btnAstigmatism1.setText("3246");
                btnAstigmatism2.setText("3240");
                btnAstigmatism3.setText("1240");
                btnAstigmatism4.setText("None of these");
                break;

            case 4:
                storageReference = storageReference.child("ast4.jpg");
                Glide.with(this)
                        .load(storageReference)
                        .into(ivAstigmatismQuestion);

                tvAstigmatismQuestion.setText("Are all the lines in the picture uniform?");
                btnAstigmatism1.setText("Yes");
                btnAstigmatism2.setText("No");
                btnAstigmatism3.setText("Varies while tilting");
                btnAstigmatism4.setText("Not sure");
                break;
        }
    }
}