package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.rajendra.foodapp.adapter.FoodAdapter;
import com.rajendra.foodapp.adapter.FoodCartAdapter;
import com.rajendra.foodapp.model.Food1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    GridView gvListFood;
    Button backButton;
    List<Food1> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        AnhXa();
        Event();
        CallData();

    }

    private  void AnhXa(){
        gvListFood = findViewById(R.id.gvListCart);
        backButton = findViewById(R.id.buttonBackCart);
    }

    private void Event() {
        this.BackEvent();
        this.EventClickItems();
    }

    private void BackEvent(){
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CartActivity.super.onBackPressed();
            }
        });
    }

    private void EventClickItems(){
        gvListFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CartActivity.this, DetailFoodNormal.class);
                intent.putExtra("DetailFood", (Serializable) foodList.get(i));
                startActivity(intent);
            }
        });
    }

    private void CallData(){
        String url = "https://android-api-1610.herokuapp.com/api/food";
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url,null,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responsed) {
                try {
                    for (int i = 0 ; i < responsed.length() ; i++) {
                        JSONObject response = (JSONObject) responsed.get(i);
                        Food1 food1 = new Food1();
                        food1.setName(response.getString("name"));
                        food1.setPrice(response.getDouble("price"));
                        food1.setRating(response.getDouble("rating"));
                        food1.setType(response.getString("type"));
                        food1.setNameRestaurent(response.getString("nameRestaurent"));
                        food1.setFoodImageUrl(response.getString("foodImageUrl"));
                        food1.setDescription(response.getString("description"));
                        foodList.add(food1);

                    }

                    Log.d("respose", responsed.toString());
                    Adapter adapter = new FoodCartAdapter(getApplicationContext(),foodList);
                    gvListFood.setAdapter((ListAdapter) adapter);
                }
                catch (JSONException e ){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("listd" , error.toString());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}