package com.osg15.biodatapps.data.local;

import android.content.Context;

import com.osg15.biodatapps.data.BiodataSource;

public class BiodataLocalDataSource implements BiodataSource {
    private Context context;
    private BiodataDao teamDao;

    public BiodataLocalDataSource(Context context) {
        this.context = context;
        teamDao = BiodataDataBase.getInstance(context).biodataDao();
    }

    @Override
    public void getListBiodata(GetBiodataCallback callback) {

    }
}
