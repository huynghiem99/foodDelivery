package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.rajendra.foodapp.adapter.FoodAdapter;
import com.rajendra.foodapp.model.Food;

import java.util.ArrayList;

public class ListFoodsActivity extends AppCompatActivity {

    GridView gvListFood;
    ArrayList<Food> foodList;
    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_foods);
        AnhXa();
        DataList();
        BindData();
    }

    private  void AnhXa(){
        gvListFood = findViewById(R.id.gvListViewFood);
    }

    private void DataList() {
        foodList = new ArrayList<>();
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
        foodList.add(new Food("Chicago Pizza", "$20", R.drawable.asiafood1, "4.5", "Briand Restaurant"));
    }

    private  void BindData(){
        foodAdapter = new FoodAdapter(getApplicationContext(), foodList);
        gvListFood.setAdapter(foodAdapter);
    }
}