package com.rajendra.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;


import com.rajendra.foodapp.Api.RetrofitInstance;
import com.rajendra.foodapp.Api.RetrofitInterface;
import com.rajendra.foodapp.adapter.FoodAdapter;
import com.rajendra.foodapp.model.Food;
import com.rajendra.foodapp.model.GeneralFood;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFoodsActivity extends AppCompatActivity {

    GridView gvListFood;
    Button backButton;
    List<Food> foodList;
    GeneralFood generalFood;
    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_foods);
        AnhXa();
        DataList();
        BindData();
        Event();
        CallData();
    }

    private  void AnhXa(){
        gvListFood = findViewById(R.id.gvListViewFood);
        backButton = findViewById(R.id.buttonBackListFood);
    }

    private void DataList() {
//        foodList = new ArrayList<>();
//        foodList.add(new Food("Chicago Pizza","Asia Food", "$30", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("Hanoi Pizza","Asia Food", "$40", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("Haiphong Pizza","Asia Food", "$50", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("HCM Pizza","Asia Food", "$60", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("New York Pizza","Asia Food", "$70", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("Chicago Pizza","Asia Food", "$80", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("Chicago Pizza","Asia Food", "$10", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("Chicago Pizza","Asia Food", "$21", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("Chicago Pizza","Asia Food", "$25", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("Chicago Pizza","Asia Food", "$28", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("Chicago Pizza","Asia Food", "$27", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
//        foodList.add(new Food("Chicago Pizza","Asia Food", "$35", R.drawable.asiafood1, "4.5", "Briand Restaurant",12,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));

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
                Intent intent = new Intent(ListFoodsActivity.this, DetailsActivity.class);
                intent.putExtra("DetailFood", (Serializable) foodList.get(i));
                startActivity(intent);
            }
        });
    }

    private void CallData(){
            Intent i = getIntent();
            generalFood = (GeneralFood) i.getSerializableExtra("GeneralFood");
            System.out.println(generalFood);

            if (generalFood.getKey() == "popularfood"){
                RetrofitInterface retrofitInterface = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
                Call<List<Food>> listCall = retrofitInterface.getAllFood();
                listCall.enqueue(new Callback<List<Food>>() {
                    @Override
                    public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                        System.out.println(1);
                        foodList = new ArrayList<>();
                        foodList = response.body();
                    }

                    @Override
                    public void onFailure(Call<List<Food>> call, Throwable t) {
                        System.out.println(2);
                    }
                });
            } else {
                RetrofitInterface retrofitInterface = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
                Call<List<Food>> listCall = retrofitInterface.getAllFoodByType(generalFood.getKey());
                listCall.enqueue(new Callback<List<Food>>() {
                    @Override
                    public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                        System.out.println(1);
                        foodList = new ArrayList<>();
                        foodList = response.body();
                    }

                    @Override
                    public void onFailure(Call<List<Food>> call, Throwable t) {
                        System.out.println(2);
                    }
                });
            }
    }
}