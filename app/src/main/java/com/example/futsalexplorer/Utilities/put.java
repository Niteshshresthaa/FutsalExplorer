package com.example.futsalexplorer.Utilities;

import com.example.futsalexplorer.model.venue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface put {

    @GET("futsal.php")
    Call<List<venue>> getData();
}
