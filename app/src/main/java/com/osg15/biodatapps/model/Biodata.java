package com.osg15.biodatapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Biodata {

    public Biodata(List<DetailBiodata> data){
        this.data = data;
    }

    @SerializedName("results")
    public List<DetailBiodata> data;


}