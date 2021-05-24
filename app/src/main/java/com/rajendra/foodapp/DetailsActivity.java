package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rajendra.foodapp.model.Food;
import com.rajendra.foodapp.model.Food1;

public class DetailsActivity extends AppCompatActivity {

    ImageView backImg, foodImg;
    TextView textViewRating, textViewNumberOrder, textViewName, textViewType, textViewPrice,textViewDescription;
    Food1 foodDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.ReceivedData();
        this.AnhXa();
        this.Event();
        this.BindData();
    }

    private void ReceivedData(){
        Intent i = getIntent();
        foodDetail = (Food1) i.getSerializableExtra("DetailFood");
        System.out.println(foodDetail);
    }

    private void AnhXa(){
        backImg = findViewById(R.id.imageViewBack);
        foodImg = findViewById(R.id.imageViewDetailFood);
        textViewRating = findViewById(R.id.textViewRating);
        textViewName = findViewById(R.id.textViewNameFood);
        textViewPrice = findViewById(R.id.textViewPriceFood);
        textViewNumberOrder = findViewById(R.id.textViewNumberOrder);
        textViewType = findViewById(R.id.textViewTypeFood);
        textViewDescription = findViewById(R.id.textViewDescriptionFood);

    }

    private void BindData(){
//        foodImg.setImageResource(foodDetail.getImageUrl());
        textViewName.setText(foodDetail.getName());
        textViewRating.setText(foodDetail.getRating()+ "");
        textViewType.setText(foodDetail.getType());
        textViewPrice.setText(foodDetail.getPrice()+ "");
        textViewDescription.setText(foodDetail.getDescription());


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
