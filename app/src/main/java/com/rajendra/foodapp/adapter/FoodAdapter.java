package com.rajendra.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajendra.foodapp.R;
import com.rajendra.foodapp.model.Food;

import java.util.ArrayList;



public class FoodAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Food> foods;

    public FoodAdapter(Context context, ArrayList<Food> foods) {
        this.context = context;
        this.foods = foods;
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int i) {
        return foods.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewHolder;
        if(view == null) {
            viewHolder = View.inflate(viewGroup.getContext(),R.layout.asia_food_row_item,null);

        } else  {
           viewHolder = view;
        }

        ImageView imageFood = viewHolder.findViewById(R.id.imagePopular);
        TextView nameFood = viewHolder.findViewById(R.id.namePopular);
        TextView priceFood = viewHolder.findViewById(R.id.pricePopular);
        TextView nameRestaurent = viewHolder.findViewById(R.id.restorant_name);
        TextView ratingFood = viewHolder.findViewById(R.id.rating);

        Food food = foods.get(i);
        imageFood.setImageResource(food.getImageUrl());
        nameFood.setText(food.getName());
        priceFood.setText(food.getPrice());
        ratingFood.setText(food.getRating());
        nameRestaurent.setText(food.getRestorantname());
        return viewHolder;
    }

}
