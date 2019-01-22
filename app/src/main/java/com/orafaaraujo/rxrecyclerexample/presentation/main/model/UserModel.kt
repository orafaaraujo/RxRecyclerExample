package com.orafaaraujo.rxrecyclerexample.presentation.main.model

class UserModel(val name: String, val description: String, var age: Int = 0) {

    fun incrementAge() {
        age++
    }
}
