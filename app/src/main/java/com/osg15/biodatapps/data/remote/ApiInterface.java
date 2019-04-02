package com.osg15.biodatapps.data.remote;

import com.osg15.biodatapps.model.Biodata;
import com.osg15.biodatapps.model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("register")
    Call<User> signup(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("login")
    Call<User> login(@Field("email") String email, @Field("password") String password);

    @GET("api/")
    Call<Biodata> getListBiodataCount(@Query("results") int count);
}
