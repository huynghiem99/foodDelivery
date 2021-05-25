package com.rajendra.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.rajendra.foodapp.adapter.FoodAdapter;
import com.rajendra.foodapp.model.Food;
import com.rajendra.foodapp.model.Food1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    ImageView backImg, foodImg, addToCart;
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
        addToCart = findViewById(R.id.buttonAddToCart);

    }

    private void BindData(){
        Glide.with(getApplicationContext())
                .load(foodDetail.getFoodImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .into(foodImg);
        textViewName.setText(foodDetail.getName());
        textViewRating.setText(foodDetail.getRating()+ "");
        textViewType.setText(foodDetail.getType());
        textViewPrice.setText(foodDetail.getPrice()+ "");
        textViewDescription.setText(foodDetail.getDescription());


    }

    private void Event(){
        this.BackEvent();
        this.AddToCartEvent();
    }

    private  void BackEvent(){
        backImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DetailsActivity.super.onBackPressed();
            }
        });
    }

    private  void AddToCartEvent(){
        addToCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("id", foodDetail.getId());
                    jsonObject.put("name", foodDetail.getName());
                    jsonObject.put("price", foodDetail.getPrice());
                    jsonObject.put("rating", foodDetail.getRating());
                    jsonObject.put("type", foodDetail.getType());
                    jsonObject.put("nameRestaurent", foodDetail.getNameRestaurent());
                    jsonObject.put("foodImageUrl", foodDetail.getFoodImageUrl());
                    jsonObject.put("description", foodDetail.getDescription());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                String url = "https://android-api-1610.herokuapp.com/api/cart";
                final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url,
                        jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(@NonNull JSONObject response) {
                        System.out.println(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(@NonNull VolleyError error) {
                    }
                }) {

                };

// Make the request
                Volley.newRequestQueue(getApplicationContext()).add(jsonObjectRequest);

            }
        });
    }
}
