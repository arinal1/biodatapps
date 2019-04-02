package com.osg15.biodatapps.navigator;

import com.osg15.biodatapps.model.Biodata;

public interface ListBiodataNavigator {

    void onLoadSuccess(Biodata biodataList);
    void onLoadFailed(String message);
}
