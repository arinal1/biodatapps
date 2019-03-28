package com.osg15.biodatapps.data;

import com.osg15.biodatapps.data.local.BiodataLocalDataSource;
import com.osg15.biodatapps.data.remote.BiodataRemoteDataSource;

public class BiodataRepository implements BiodataSource {
    public BiodataRepository(BiodataRemoteDataSource biodataRemoteDataSource, BiodataLocalDataSource biodataLocalDataSource) {
    }

    @Override
    public void getListBiodata(GetBiodataCallback callback) {

    }
}
