package com.osg15.biodatapps.data.remote;

import android.support.annotation.NonNull;

import com.osg15.biodatapps.data.BiodataSource;
import com.osg15.biodatapps.model.Biodata;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BiodataRemoteDataSource implements BiodataSource {

    @Override
    public void getListBiodataCount(int count, final GetBiodataCallback callback) {
        ApiClient.getBiodata().create(ApiInterface.class)
                .getListBiodataCount(count)
                .enqueue(new Callback<Biodata>() {
                    @Override
                    public void onResponse(@NonNull Call<Biodata> call, @NonNull Response<Biodata> response) {
                        callback.onGetSuccess(response.body());
                    }

                    @Override
                    public void onFailure(@NonNull Call<Biodata> call, @NonNull Throwable t) {
                        callback.onGetFailed(t.getMessage());
                    }
                });
    }
}
