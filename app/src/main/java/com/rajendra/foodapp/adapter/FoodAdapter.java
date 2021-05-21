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

import java.util.List;

public class FoodAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Food> foods;

    public FoodAdapter(Context context, int layout, List<Food> foods) {
        this.context = context;
        this.layout = layout;
        this.foods = foods;
    }

    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imageFood;
        TextView nameFood;
        TextView priceFood;
        TextView nameRestaurent;
        TextView ratingFood;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FoodAdapter.ViewHolder viewHolder;
        if(view == null) {
            viewHolder = new FoodAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.imageFood = (ImageView) view.findViewById(R.id.imagePopular);
            viewHolder.nameFood = (TextView) view.findViewById(R.id.nameGeneralFood);
            viewHolder.priceFood = (TextView) view.findViewById(R.id.pricePopular);
            viewHolder.ratingFood = (TextView) view.findViewById(R.id.rating);
            viewHolder.nameRestaurent = (TextView) view.findViewById(R.id.restorant_name);

            view.setTag(viewHolder);

        } else  {
            viewHolder = (FoodAdapter.ViewHolder) view.getTag();
        }

        Food food = foods.get(i);
        viewHolder.imageFood.setImageResource(food.getImageUrl());
        viewHolder.nameFood.setText(food.getName());
        viewHolder.priceFood.setText(food.getPrice());
        viewHolder.ratingFood.setText(food.getRating());
        viewHolder.nameRestaurent.setText(food.getRestorantname());
        return view;
    }

}
