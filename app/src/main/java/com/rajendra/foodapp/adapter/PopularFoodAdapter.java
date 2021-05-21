package com.rajendra.foodapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.foodapp.DetailsActivity;
import com.rajendra.foodapp.MainActivity;
import com.rajendra.foodapp.R;
import com.rajendra.foodapp.model.PopularFood;

import java.util.List;


public class PopularFoodAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<PopularFood> popularFoodList;

    public PopularFoodAdapter(Context context, int layout, List<PopularFood> popularFoodList) {
        this.context = context;
        this.layout = layout;
        this.popularFoodList = popularFoodList;
    }

    @Override
    public int getCount() {
        return popularFoodList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        //anh xa view
        TextView txtPrice = (TextView) view.findViewById(R.id.pricePopular);
        TextView txtName = (TextView) view.findViewById(R.id.namePopular);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imagePopular);

        //gan gia tri
        PopularFood popularFood = popularFoodList.get(i);
        txtName.setText(popularFood.getName());
        txtPrice.setText(popularFood.getPrice());
        imgHinh.setImageResource(popularFood.getImageUrl());

        return view;
    }
}
