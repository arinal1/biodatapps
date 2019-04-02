package com.osg15.biodatapps.data.local;

import android.content.Context;

import com.osg15.biodatapps.data.BiodataSource;
import com.osg15.biodatapps.model.Biodata;
import com.osg15.biodatapps.model.DetailBiodata;

import java.util.List;

public class BiodataLocalDataSource implements BiodataSource {

    private BiodataDao dao;

    public BiodataLocalDataSource(Context context) {
        dao = BiodataDataBase.getInstance(context).biodataDao();
    }
    @Override
    public void getListBiodataCount(final int count, final GetBiodataCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<DetailBiodata> biodata = dao.getBiodataCount(count);
                if (biodata.isEmpty()) callback.onGetFailed("Data lokal kosong");
                else callback.onGetSuccess(new Biodata(biodata));
            }
        }).start();
    }

    public void saveData(final List<DetailBiodata> biodata){
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insert(biodata);
            }
        }).start();
    }
}
