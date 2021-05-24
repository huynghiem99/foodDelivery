package com.rajendra.foodapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rajendra.foodapp.R;
import com.rajendra.foodapp.model.Food1;

import java.util.List;

public class FoodCartAdapter extends BaseAdapter {

    private Context context;
    private List<Food1> foods;

    public FoodCartAdapter(Context context, List<Food1> foods) {
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
            viewHolder = View.inflate(viewGroup.getContext(), R.layout.popular_food_row_item,null);

        } else  {
            viewHolder = view;
        }

        ImageView imageFood = viewHolder.findViewById(R.id.imagePopular);
        TextView nameFood = viewHolder.findViewById(R.id.namePopular);
        TextView priceFood = viewHolder.findViewById(R.id.pricePopular);

        Food1 food = foods.get(i);

        Glide.with(viewHolder)
                .load(food.getFoodImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .into(imageFood);

        nameFood.setText(food.getName());
        priceFood.setText(food.getPrice()+"");
        return viewHolder;
    }

}
