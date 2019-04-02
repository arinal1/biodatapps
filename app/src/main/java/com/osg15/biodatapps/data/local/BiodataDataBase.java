package com.osg15.biodatapps.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.osg15.biodatapps.model.DetailBiodata;

@Database(entities = {DetailBiodata.class}, version = 1, exportSchema = false)
abstract class BiodataDataBase extends RoomDatabase {
    private static BiodataDataBase INSTANCE;

    abstract BiodataDao biodataDao();

    private static final Object sLock = new Object();

    static BiodataDataBase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        BiodataDataBase.class, "Biodata.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
