package com.osg15.biodatapps.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.osg15.biodatapps.model.DetailBiodata;

import java.util.List;

@Dao
public interface BiodataDao {

    @Query("SELECT * FROM Biodata LIMIT :count")
    List<DetailBiodata> getBiodataCount(int count);

    @Insert
    void insert(List<DetailBiodata> biodata);
}
