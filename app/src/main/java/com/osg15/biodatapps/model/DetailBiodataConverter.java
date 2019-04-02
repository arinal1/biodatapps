package com.osg15.biodatapps.model;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.osg15.biodatapps.model.DetailBiodata.*;

public class DetailBiodataConverter {

    public static class NameTypeConverter {
        @TypeConverter
        public static Name fromString(String nameJson) {
            if (nameJson == null) return null;
            Gson gson = new Gson();
            return gson.fromJson(nameJson, Name.class);
        }

        @TypeConverter
        public static String toString(Name name) {
            if (name == null) return null;
            Gson gson = new Gson();
            return gson.toJson(name);
        }
    }

    public static class LocationTypeConverter {
        @TypeConverter
        public static Location fromString(String locationJson) {
            if (locationJson == null) return null;
            Gson gson = new Gson();
            return gson.fromJson(locationJson, Location.class);
        }

        @TypeConverter
        public static String toString(Location location) {
            if (location == null) return null;
            Gson gson = new Gson();
            return gson.toJson(location);
        }
    }

    public static class DobTypeConverter {
        @TypeConverter
        public static Dob fromString(String dobJson) {
            if (dobJson == null) return null;
            Gson gson = new Gson();
            return gson.fromJson(dobJson, Dob.class);
        }

        @TypeConverter
        public static String toString(Dob dob) {
            if (dob == null) return null;
            Gson gson = new Gson();
            return gson.toJson(dob);
        }
    }

    public static class IdTypeConverter {
        @TypeConverter
        public static Id fromString(String idJson) {
            if (idJson == null) return null;
            Gson gson = new Gson();
            return gson.fromJson(idJson, Id.class);
        }

        @TypeConverter
        public static String toString(Id id) {
            if (id == null) return null;
            Gson gson = new Gson();
            return gson.toJson(id);
        }
    }

    public static class PictureTypeConverter {
        @TypeConverter
        public static Picture fromString(String pictureJson) {
            if (pictureJson == null) return null;
            Gson gson = new Gson();
            return gson.fromJson(pictureJson, Picture.class);
        }

        @TypeConverter
        public static String toString(Picture picture) {
            if (picture == null) return null;
            Gson gson = new Gson();
            return gson.toJson(picture);
        }
    }

    public static class CoordinatesTypeConverter {
        @TypeConverter
        public static Coordinates fromString(String coordinatesJson) {
            if (coordinatesJson == null) return null;
            Gson gson = new Gson();
            return gson.fromJson(coordinatesJson, Coordinates.class);
        }

        @TypeConverter
        public static String toString(Coordinates coordinates) {
            if (coordinates == null) return null;
            Gson gson = new Gson();
            return gson.toJson(coordinates);
        }
    }

}
