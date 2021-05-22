package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.rajendra.foodapp.adapter.FoodAdapter;
import com.rajendra.foodapp.model.Food;

import java.util.ArrayList;

public class ListFoodsActivity extends AppCompatActivity {

    GridView gvListFood;
    Button backButton;
    ArrayList<Food> foodList;
    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_foods);
        AnhXa();
        DataList();
        BindData();
        Event();
    }

    private  void AnhXa(){
        gvListFood = findViewById(R.id.gvListViewFood);
        backButton = findViewById(R.id.buttonBackListFood);
    }

    private void DataList() {
        foodList = new ArrayList<>();
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood2, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood2, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood2, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood2, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood2, "4.5", "Briand Restaurant"));
    }

    private  void BindData(){
        foodAdapter = new FoodAdapter(getApplicationContext(), foodList);
        gvListFood.setAdapter(foodAdapter);
    }

    private void Event() {
        this.BackEvent();
        this.EventClickItems();
    }

    private void BackEvent(){
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ListFoodsActivity.super.onBackPressed();
            }
        });
    }

    private void EventClickItems(){
        gvListFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openFoodListScreen();
            }
        });
    }

    private void openFoodListScreen() {
        Intent intent = new Intent(ListFoodsActivity.this, DetailsActivity.class);
        startActivity(intent);
    }
}