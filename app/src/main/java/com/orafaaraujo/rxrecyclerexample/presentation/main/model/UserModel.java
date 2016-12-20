package com.orafaaraujo.rxrecyclerexample.presentation.main.model;

/**
 * Created by rafael on 01/12/16.
 */

public class UserModel {

    private final String mName;
    private final String mCity;
    private int mAge;

    public UserModel(String name, String city, int age) {
        mName = name;
        mCity = city;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public String getCity() {
        return mCity;
    }

    public int getAge() {
        return mAge;
    }

    public void incrementAge() {
        mAge++;
    }
}
