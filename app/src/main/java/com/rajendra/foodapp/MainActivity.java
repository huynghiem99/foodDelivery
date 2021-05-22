package com.rajendra.foodapp;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.content.Intent;
import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;


import com.rajendra.foodapp.adapter.GeneralFoodAdapter;
import com.rajendra.foodapp.model.GeneralFood;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvGeneralFood;
    ArrayList<GeneralFood> generalFoodList;
    GeneralFoodAdapter generalFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        DataList();
        BindData();
        EventClickItems();
    }

    private  void AnhXa(){
        gvGeneralFood = findViewById(R.id.gridViewGeneral);
    }

    private void DataList() {
        generalFoodList = new ArrayList<>();
        generalFoodList.add(new GeneralFood("Popular Food",R.drawable.a));
        generalFoodList.add(new GeneralFood("Asia Food",R.drawable.b));
        generalFoodList.add(new GeneralFood("Europe Food",R.drawable.c));
        generalFoodList.add(new GeneralFood("Africa Food",R.drawable.d));
    }

    private  void BindData(){
        generalFoodAdapter = new GeneralFoodAdapter(getApplicationContext(), generalFoodList);
        gvGeneralFood.setAdapter(generalFoodAdapter);
    }

    private void EventClickItems(){
        gvGeneralFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openFoodListScreen();
            }
        });
    }

    private void openFoodListScreen() {
        Intent intent = new Intent(MainActivity.this, ListFoodsActivity.class);
        startActivity(intent);
    }
}
