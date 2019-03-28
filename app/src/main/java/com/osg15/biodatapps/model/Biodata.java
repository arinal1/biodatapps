package com.osg15.biodatapps.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "biodata")
public class Biodata {
    @PrimaryKey(autoGenerate = true)
    public int id;
}
