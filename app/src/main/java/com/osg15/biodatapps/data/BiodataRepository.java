package com.osg15.biodatapps.data;

import com.osg15.biodatapps.data.local.BiodataLocalDataSource;
import com.osg15.biodatapps.data.remote.BiodataRemoteDataSource;
import com.osg15.biodatapps.model.Biodata;

public class BiodataRepository implements BiodataSource {

    private BiodataLocalDataSource localDataSource;
    private BiodataRemoteDataSource remoteDataSource;

    public BiodataRepository(BiodataRemoteDataSource biodataRemoteDataSource, BiodataLocalDataSource biodataLocalDataSource) {
        localDataSource = biodataLocalDataSource;
        remoteDataSource = biodataRemoteDataSource;
    }

    @Override
    public void getListBiodataCount(final int count, final GetBiodataCallback callback) {
        localDataSource.getListBiodataCount(count, new GetBiodataCallback() {
            @Override
            public void onGetSuccess(Biodata data) {callback.onGetSuccess(data);}

            @Override
            public void onGetFailed(String errorMessage) {getRemoteListBiodata(count, callback);}
        });
    }

    private void getRemoteListBiodata(int count, final GetBiodataCallback callback){
        remoteDataSource.getListBiodataCount(count, new GetBiodataCallback() {
            @Override
            public void onGetSuccess(Biodata data) {
                localDataSource.saveData(data.data);
                callback.onGetSuccess(data);
            }

            @Override
            public void onGetFailed(String errorMessage) {callback.onGetFailed(errorMessage);}
        });
    }
}