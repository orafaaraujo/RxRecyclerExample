package com.orafaaraujo.rxrecyclerexample.presentation.main.model;

/**
 * Created by rafael on 01/12/16.
 */

public class UserModel {

    private final String mName;
    private final String mCity;
    private final String mDescription;
    private int mAge;

    public UserModel(String name, String city, String description, int age) {
        mName = name;
        mCity = city;
        mDescription = description;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public String getCity() {
        return mCity;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getAge() {
        return mAge;
    }

    public void incrementAge() {
        mAge++;
    }
}
