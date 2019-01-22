package com.orafaaraujo.rxrecyclerexample.presentation.main.repository;

import com.orafaaraujo.rxrecyclerexample.presentation.main.model.UserModel;

import java.util.Random;

/**
 * Created by rafael on 01/12/16.
 */

class UserFactory {

    private static String[] names = {"Alan", "Arthur", "Nicolas", "Angela", "Brenda", "Liz"};
    private static String[] cities = {"Rio", "Miami", "Paris", "Montevideo", "Tokyo", "Nairobi"};
    private static String[] desc = {"\"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n " +
            "Etiam eget ligula eu lectus lobortis condimentum.\n Aliquam nonummy auctor massa.\"",
            "\"Quis custodiet ipsos custodes?\""};

    static UserModel makeUser() {
        return new UserModel(names[getRandomValue(0, 5)],
                cities[getRandomValue(0, 5)],
                desc[getRandomValue(0, 2)],
                getRandomValue(18, 40));
    }

    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }
}
