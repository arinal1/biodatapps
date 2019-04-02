package com.osg15.biodatapps.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.osg15.biodatapps.model.DetailBiodataConverter.*;

@Entity(tableName = "biodata")
public class DetailBiodata {
    @PrimaryKey(autoGenerate = true)
    public int key;
    @SerializedName("gender")
    @ColumnInfo(name = "gender")
    public String gender;
    @TypeConverters(NameTypeConverter.class)
    @SerializedName("name")
    public Name name;
    @TypeConverters(LocationTypeConverter.class)
    @SerializedName("location")
    public Location location;
    @SerializedName("email")
    @ColumnInfo(name = "email")
    public String email;
    @TypeConverters(DobTypeConverter.class)
    @SerializedName("dob")
    public Dob dob;
    @SerializedName("cell")
    @ColumnInfo(name = "cell")
    public String cell;
    @TypeConverters(IdTypeConverter.class)
    @SerializedName("id")
    public Id identity;
    @TypeConverters(PictureTypeConverter.class)
    @SerializedName("picture")
    public Picture picture;

    public class Coordinates {
        @SerializedName("latitude")
        @ColumnInfo(name = "latitude")
        public String latitude;
        @SerializedName("longitude")
        @ColumnInfo(name = "longitude")
        public String longitude;
    }

    public class Dob {
        @SerializedName("date")
        @ColumnInfo(name = "date")
        public String date;
        @SerializedName("age")
        @ColumnInfo(name = "age")
        public Integer age;
    }

    public class Id {
        @SerializedName("name")
        @ColumnInfo(name = "name")
        public String name;
        @SerializedName("value")
        @ColumnInfo(name = "value")
        public String value;
    }
    public class Location {
        @SerializedName("street")
        @ColumnInfo(name = "street")
        public String street;
        @SerializedName("city")
        @ColumnInfo(name = "city")
        public String city;
        @SerializedName("state")
        @ColumnInfo(name = "state")
        public String state;
        @SerializedName("postcode")
        @ColumnInfo(name = "postcode")
        public Integer postcode;
        @TypeConverters(CoordinatesTypeConverter.class)
        @SerializedName("coordinates")
        public Coordinates coordinates;
    }
    public class Name {
        @SerializedName("title")
        @ColumnInfo(name = "title")
        public String title;
        @SerializedName("first")
        @ColumnInfo(name = "first")
        public String first;
        @SerializedName("last")
        @ColumnInfo(name = "last")
        public String last;
    }
    public class Picture {
        @SerializedName("large")
        @ColumnInfo(name = "large")
        public String large;
        @SerializedName("medium")
        @ColumnInfo(name = "medium")
        public String medium;
        @SerializedName("thumbnail")
        @ColumnInfo(name = "thumbnail")
        public String thumbnail;
    }
}
