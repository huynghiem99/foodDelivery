package com.rajendra.foodapp.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rajendra.foodapp.R;
import com.rajendra.foodapp.model.GeneralFood;

import java.util.List;

public class GeneralFoodAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<GeneralFood> generalFoods;

    public GeneralFoodAdapter(Context context, int layout, List<GeneralFood> generalFoods) {
        this.context = context;
        this.layout = layout;
        this.generalFoods = generalFoods;
    }

    @Override
    public int getCount() {
        return generalFoods.size();
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
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder.imageFood = (ImageView) view.findViewById(R.id.imgGeneralFood);
            viewHolder.nameFood = (TextView) view.findViewById(R.id.nameGeneralFood);

            view.setTag(viewHolder);

        } else  {
            viewHolder = (ViewHolder) view.getTag();
        }

        GeneralFood generalFood = generalFoods.get(i);
        viewHolder.imageFood.setImageResource(generalFood.getImageGeneral());
        viewHolder.nameFood.setText(generalFood.getName());
        return view;
    }
}
