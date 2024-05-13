package com.example.futsalexplorer.Utilities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class controller {

    private static final String url = "http://10.0.2.2/api/";
    private static controller clientobject;
    private static Retrofit retrofit;

    controller(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized controller getInstance(){
        if(clientobject==null)
            clientobject= new controller();

        return clientobject;
    }

    public put getapi(){
        return retrofit.create(put.class);
    }
}
