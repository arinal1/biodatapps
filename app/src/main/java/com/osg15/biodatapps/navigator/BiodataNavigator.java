package com.osg15.biodatapps.navigator;

import com.osg15.biodatapps.model.Biodata;

import java.util.List;

public interface BiodataNavigator {

    void onLoadList(List<Biodata> listTeam);
    void onErrorLoadList(String message);
}
