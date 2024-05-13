package com.example.futsalexplorer.Utilities;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.futsalexplorer.MainActivity;
import com.example.futsalexplorer.model.ReqLogin;
import com.example.futsalexplorer.model.ReqRegister;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public ApiService serviceApi = retrofit.create(ApiService.class);
    public void registerUser(String username, String email, String password, String phonenumber){


        ReqRegister reqRegister = new ReqRegister(username, email, password, phonenumber);
        Call<ReqRegister> call = serviceApi.regis(reqRegister);
        Log.d("api call", "in data ");
   call.enqueue(new Callback<ReqRegister>() {
       @Override
       public void onResponse(Call<ReqRegister> call, Response<ReqRegister> response) {
           Log.d("api called", "in response");
           if (response.isSuccessful()) {
               Log.d("api called", "User registered successfully");
           } else {
               Log.e("api called", "Failed to register user: " + response.message());
           }
       }

       @Override
       public void onFailure(Call<ReqRegister> call, Throwable throwable) {

           Log.e("api called", "Failed to register user: " + throwable.getMessage());

       }
   });

    }

    public void loginuser(String username, String password, Activity activity)
    {
        ReqLogin reqLogin = new ReqLogin(username, password);

        Call reqLoginCall = serviceApi.regt(reqLogin);
        reqLoginCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Log.d("api called", "in response");
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                if (response.isSuccessful()) {
                    Log.d("api called", "User registered successfully");

                } else {
                    Log.e("api called", "Failed to register user: " + response.message());
                }
            }

            @Override
            public void onFailure(Call call, Throwable throwable) {

            }
        });



    }
}