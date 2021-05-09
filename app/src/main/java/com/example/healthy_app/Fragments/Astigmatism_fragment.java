package com.example.healthy_app.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.healthy_app.Activities.Profile_Activity;
import com.example.healthy_app.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mackhartley.roundedprogressbar.RoundedProgressBar;

import java.util.ArrayList;


public class Astigmatism_fragment extends Fragment {

    View view;
    ImageView ivAstigmatismQuestion;
    TextView tvAstigmatismQuestion;
    Button btnAstigmatism1, btnAstigmatism2, btnAstigmatism3, btnAstigmatism4;

    Bitmap bitmap_one;
    Bitmap bitmap_two;
    Bitmap bitmap_three;
    int coins_f=0;
    int badges_f=0;
    Bitmap bitmap_four;

    TextView badges_text;
    TextView coins_text;

    RoundedProgressBar roundedProgressBar;

    RelativeLayout progress_layout;
    ProgressBar circle_progress;





    FirebaseStorage firebaseStorage;
    StorageReference storageReference;

    final long ONE_MEGABYTE = 1024 * 1024;

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

//       progress_layout = view.findViewById(R.id.progress_layout);
//       circle_progress = view.findViewById(R.id.circle_progress);
//       roundedProgressBar = view.findViewById(R.id.progress_bar);
//       badges_text = view.findViewById(R.id.badges_text);
//       coins_text = view.findViewById(R.id.coins_text);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        progress_layout = view.findViewById(R.id.progress_layout);
        circle_progress = view.findViewById(R.id.circle_progress);
        roundedProgressBar = view.findViewById(R.id.progress_bar);
        badges_text = view.findViewById(R.id.badges_text);
        coins_text = view.findViewById(R.id.coins_text);


        ivAstigmatismQuestion = view.findViewById(R.id.ivAstigmatismQuestion);
        tvAstigmatismQuestion = view.findViewById(R.id.tvAstigmatismQuestion);
        btnAstigmatism1 = view.findViewById(R.id.btnAstigmatism1);
        btnAstigmatism2 = view.findViewById(R.id.btnAstigmatism2);
        btnAstigmatism3 = view.findViewById(R.id.btnAstigmatism3);
        btnAstigmatism4 = view.findViewById(R.id.btnAstigmatism4);

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference("Astigmatism");

        loading_image();

        questionNumber = 1;

//        loadData(questionNumber);

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

                        Intent intent = new Intent(getActivity() , Profile_Activity.class);
                        coins_f++;
                        badges_f++;
                        intent.putExtra("coins" , coins_f);
                        intent.putExtra("badges" , badges_f);
                        startActivity(intent);
                        break;
                }

                update_progress(answerStatus);
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
                        Intent intent = new Intent(getActivity() , Profile_Activity.class);
                        intent.putExtra("coins" , coins_f);
                        intent.putExtra("badges" , badges_f);
                        startActivity(intent);

                        break;
                }

                update_progress(answerStatus);
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
                        Intent intent = new Intent(getActivity() , Profile_Activity.class);
                        intent.putExtra("coins" , coins_f);
                        intent.putExtra("badges" , badges_f);
                        startActivity(intent);

                        break;
                }

                update_progress(answerStatus);
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
                        Intent intent = new Intent(getActivity() , Profile_Activity.class);
                        intent.putExtra("coins" , coins_f);
                        intent.putExtra("badges" , badges_f);
                        startActivity(intent);

                        break;
                }
                update_progress(answerStatus);
                questionNumber++;
                loadData(questionNumber);
            }
        });


    }

    private void update_progress( int answers[]) {
         int count=0;
        for(int i=0 ;i<answers.length ; i++)
        {
            if(answers[i]==1)
            {
                count++;
            }
        }
        if(count==1)
        {
            roundedProgressBar.setProgressPercentage(25,false);

        }
        else if(count==2)
        {
            roundedProgressBar.setProgressPercentage(50,false);

        }
        else if(count==3)
        {
            roundedProgressBar.setProgressPercentage(75,false);

        }
        else if(count==4)
        {
            roundedProgressBar.setProgressPercentage(100,false);

        }


        coins_text.setText(count+"");
        badges_text.setText((int)(count/2)+"");
        coins_f= count;
        badges_f = (int)(count/2);



    }

    private void loadData(int questionNumber)
    {
        switch (questionNumber){

            case 1:
//                storageReference.child("ast1.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//                    @Override
//                    public void onSuccess(byte[] bytes) {
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                        ivAstigmatismQuestion.setImageBitmap(bitmap);
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        Toast.makeText(getContext(), "Error occured:" + exception.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
                  ivAstigmatismQuestion.setImageBitmap(bitmap_one);

                tvAstigmatismQuestion.setText("How many lines are present here?");
                btnAstigmatism1.setText("24");
                btnAstigmatism2.setText("30");
                btnAstigmatism3.setText("36");
                btnAstigmatism4.setText("12");
                break;

            case 2:
//                storageReference.child("ast2.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//                    @Override
//                    public void onSuccess(byte[] bytes) {
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                        ivAstigmatismQuestion.setImageBitmap(bitmap);
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        Toast.makeText(getContext(), "Error occured:" + exception.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
                ivAstigmatismQuestion.setImageBitmap(bitmap_two);

                tvAstigmatismQuestion.setText("How many lines are light grey shaded?");
                btnAstigmatism1.setText("24");
                btnAstigmatism2.setText("4");
                btnAstigmatism3.setText("36");
                btnAstigmatism4.setText("12");
                break;

            case 3:
//                storageReference.child("ast3.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//                    @Override
//                    public void onSuccess(byte[] bytes) {
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                        ivAstigmatismQuestion.setImageBitmap(bitmap);
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        Toast.makeText(getContext(), "Error occured:" + exception.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
                ivAstigmatismQuestion.setImageBitmap(bitmap_three);

                tvAstigmatismQuestion.setText("What number do you see here?");
                btnAstigmatism1.setText("3246");
                btnAstigmatism2.setText("3240");
                btnAstigmatism3.setText("1240");
                btnAstigmatism4.setText("NOTA");
                break;

            case 4:
//                storageReference.child("ast4.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//                    @Override
//                    public void onSuccess(byte[] bytes) {
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                        ivAstigmatismQuestion.setImageBitmap(bitmap);
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        Toast.makeText(getContext(), "Error occured:" + exception.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });

                ivAstigmatismQuestion.setImageBitmap(bitmap_four);


                tvAstigmatismQuestion.setText("Are all the lines in the picture uniform?");
                btnAstigmatism1.setText("Yes");
                btnAstigmatism2.setText("No");
                btnAstigmatism3.setText("Varies while tilting");
                btnAstigmatism4.setText("Not sure");

                break;
        }
    }


    public void loading_image()
    {

        storageReference.child("ast1.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                bitmap_one = bitmap;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getContext(), "Error occured:" + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        storageReference.child("ast2.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);


               bitmap_two= bitmap;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getContext(), "Error occured:" + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        storageReference.child("ast3.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                bitmap_three= bitmap;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getContext(), "Error occured:" + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        storageReference.child("ast4.jpg").getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

                bitmap_four = bitmap;
                circle_progress.setVisibility(View.GONE);
                progress_layout.setVisibility(View.GONE);
                loadData(1);
             }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getContext(), "Error occured:" + exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}