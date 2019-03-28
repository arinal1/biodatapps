package com.osg15.biodatapps;

import android.content.Context;

import com.osg15.biodatapps.data.BiodataRepository;
import com.osg15.biodatapps.data.local.BiodataLocalDataSource;
import com.osg15.biodatapps.data.remote.BiodataRemoteDataSource;

public class Injection {
    public static BiodataRepository provideTeamRepository(Context context) {
        return new BiodataRepository (new BiodataRemoteDataSource(), new BiodataLocalDataSource(context));
    }
}
