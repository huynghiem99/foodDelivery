package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetailsActivity extends AppCompatActivity {

    ImageView backImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.AnhXa();
        this.Event();
    }

    private void AnhXa(){
        backImg = findViewById(R.id.imageViewBack);
    }

    private void Event(){
        this.BackEvent();
    }

    private  void BackEvent(){
        backImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DetailsActivity.super.onBackPressed();
            }
        });
    }
}
