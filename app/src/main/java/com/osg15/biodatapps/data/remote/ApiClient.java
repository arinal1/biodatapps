package com.osg15.biodatapps.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getBiodata() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public static Retrofit getUser() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
