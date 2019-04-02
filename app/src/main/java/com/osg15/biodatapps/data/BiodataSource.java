package com.osg15.biodatapps.data;

import com.osg15.biodatapps.model.Biodata;

public interface BiodataSource {
    void getListBiodataCount(int count, GetBiodataCallback callback);

    interface GetBiodataCallback {
        void onGetSuccess(Biodata data);
        void onGetFailed(String errorMessage);
    }
}
