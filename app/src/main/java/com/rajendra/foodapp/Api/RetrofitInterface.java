package com.rajendra.foodapp.Api;

import com.rajendra.foodapp.model.Food;
import com.rajendra.foodapp.model.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("/photos")
    Call<List<PhotoModel>> getAllPhotos();
}
