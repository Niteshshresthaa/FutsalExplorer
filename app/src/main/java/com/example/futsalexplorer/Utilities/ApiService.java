package com.example.futsalexplorer.Utilities;


import com.example.futsalexplorer.model.ReqLogin;
import com.example.futsalexplorer.model.ReqRegister;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("registerhome.php")
    Call<ReqRegister> regis(@Body ReqRegister request);

    @POST("login.php")
    Call<ReqLogin> regt(@Body ReqLogin request);

}