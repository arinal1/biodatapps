package com.osg15.biodatapps.data.remote;

import com.osg15.biodatapps.data.UserSource;
import com.osg15.biodatapps.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRemoteDataSource implements UserSource {

    @Override
    public void login(String email, String password, final UserCallback callback) {
        ApiClient.getUser().create(ApiInterface.class)
                .login(email, password)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        callback.onDataLoaded(response.body());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        callback.onDataNotAvailable(t.getMessage());
                    }
                });
    }

    @Override
    public void signup(String email, String password, final UserCallback callback) {
        ApiClient.getUser().create(ApiInterface.class)
                .signup(email, password)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        callback.onDataLoaded(response.body());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        callback.onDataNotAvailable(t.getMessage());
                    }
                });
    }
}
