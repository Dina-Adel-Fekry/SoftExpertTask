package com.example.softexpertdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.softexpertdemo.Model.Car;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SwipeRefreshLayout pullToRefresh = findViewById(R.id.swipeRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView = findViewById(R.id.carsInfo);
                layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                start();
                pullToRefresh.setRefreshing(false);

            }
        });




    }

    static final String BASE_URL = "http://demo1585915.mockable.io/";

    public void start() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        ApiInterface api = retrofit.create(ApiInterface.class);

        for (int i = 1; i < 4; i++) {
            Call<Object> call = api.getCars(i);
            call.enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {

                    Object carsList = response.body();

                    List<Car> cars = new ArrayList<>();
                   // cars = carsList.getData();
                    adapter = new Adapter(MainActivity.this,cars);
                    recyclerView.setAdapter(adapter);
                    System.out.println(carsList);
                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                    t.printStackTrace();
                    System.out.println("fail to load");
                }


            });

        }
    }
}