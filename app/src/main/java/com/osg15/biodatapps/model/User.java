package com.osg15.biodatapps.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("token")
    private String token;
    @SerializedName("error")
    private String error;
}
