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
import com.rajendra.foodapp.model.GeneralFood;

import java.util.ArrayList;
import java.util.List;

public class GeneralFoodAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<GeneralFood> generalFoods;

    public GeneralFoodAdapter(Context context, ArrayList<GeneralFood> generalFoods) {
        this.context = context;
        this.generalFoods = generalFoods;
    }

    @Override
    public int getCount() {
        return generalFoods.size();
    }

    @Override
    public Object getItem(int i) {
        return generalFoods.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewHolder;
        if(view == null) {
            viewHolder = View.inflate(viewGroup.getContext(),R.layout.genral_food_item,null);

        } else  {
            viewHolder = view;
        }

        ImageView imageFood = viewHolder.findViewById(R.id.imgGeneralFood);
        TextView nameFood = viewHolder.findViewById(R.id.nameGeneralFood);

        GeneralFood generalFood = generalFoods.get(i);
        imageFood.setImageResource(generalFood.getImageGeneral());
        nameFood.setText(generalFood.getName());
        return viewHolder;
    }
}
