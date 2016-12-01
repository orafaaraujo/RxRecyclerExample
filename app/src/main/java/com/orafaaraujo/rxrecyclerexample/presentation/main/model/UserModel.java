package com.orafaaraujo.rxrecyclerexample.presentation.main.model;

/**
 * Created by rafael on 01/12/16.
 */

public class UserModel {

    private final String mName;
    private final String mCity;
    private final int mPoints;

    public UserModel(String name, String city, int points) {
        mName = name;
        mCity = city;
        mPoints = points;
    }

    public String getName() {
        return mName;
    }

    public String getCity() {
        return mCity;
    }

    public int getPoints() {
        return mPoints;
    }


}
