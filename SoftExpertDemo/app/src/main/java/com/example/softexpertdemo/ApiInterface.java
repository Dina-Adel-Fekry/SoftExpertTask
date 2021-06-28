package com.example.softexpertdemo;

import com.example.softexpertdemo.Model.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/v1/cars/")
    Call<Object> getCars(@Query("page") int page);
}
