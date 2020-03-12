package com.example.ontap2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvList ;
    private commentsApdater commentsApdater;
    List<comments> commentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList =  findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);


        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<comments>> call = jsonPlaceHolderApi.getComments();
        call.enqueue(new Callback<List<comments>>() {
            @Override
            public void onResponse(Call<List<comments>> call, Response<List<comments>> response) {
                commentsList.addAll(response.body());
                commentsApdater = new commentsApdater(MainActivity.this,commentsList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                rvList.setLayoutManager(linearLayoutManager);
                rvList.setAdapter(commentsApdater);
            }

            @Override
            public void onFailure(Call<List<comments>> call, Throwable t) {

            }
        });
    }
}
