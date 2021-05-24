package com.rajendra.foodapp.Api;

import com.rajendra.foodapp.model.Food;
import com.rajendra.foodapp.model.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("api/food")
    Call<List<Food>> getAllFood();

    @GET("api/food/gettype")
    Call<List<Food>> getAllFoodByType(@Query("type") String type);
}
