package com.osg15.biodatapps.data;

import com.osg15.biodatapps.model.Biodata;

public interface BiodataSource {
    void getListBiodata(GetBiodataCallback callback);


    interface GetBiodataCallback {
        void onDataLoaded(Biodata data);
        void onDataNotAvailable(String errorMessage);
    }
}
