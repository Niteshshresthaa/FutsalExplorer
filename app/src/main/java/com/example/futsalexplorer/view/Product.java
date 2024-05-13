package com.example.futsalexplorer.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.futsalexplorer.R;
import com.example.futsalexplorer.Utilities.adapt;
import com.example.futsalexplorer.Utilities.controller;
import com.example.futsalexplorer.model.venue;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Product extends AppCompatActivity {

    RecyclerView view;
    adapt Adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        view = findViewById(R.id.view);
        view.setLayoutManager(new LinearLayoutManager(this));

        Adapt = new adapt(new ArrayList<>(), this);
        view.setAdapter(Adapt);

        processdata();
    }

    public void processdata() {
        Call<List<venue>> call = controller
                .getInstance()
                .getapi()
                .getData();

        call.enqueue(new Callback<List<venue>>() {
            @Override
            public void onResponse(@NonNull Call<List<venue>> call, @NonNull Response<List<venue>> response) {
                if (response.isSuccessful()) {
                    List<venue> dataList = response.body();
                    if (dataList != null && !dataList.isEmpty()) {
                        Adapt.updateList(new ArrayList<>(dataList));
                    } else {
                        Toast.makeText(Product.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Product.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<venue>> call, @NonNull Throwable t) {
                Toast.makeText(Product.this, "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}