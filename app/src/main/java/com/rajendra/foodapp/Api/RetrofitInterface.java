package com.rajendra.foodapp.Api;

import com.rajendra.foodapp.model.Food;
import com.rajendra.foodapp.model.Food1;
import com.rajendra.foodapp.model.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("/api/food")
    Call<List<Food1>> getAllFood();

    @GET("/api/food/gettype?type=asiafood")
    Call<List<Food1>> getAllFoodByType();
}
