package com.orafaaraujo.rxrecyclerexample.presentation.main.repository

import com.orafaaraujo.rxrecyclerexample.presentation.main.model.UserModel

import java.util.Random

internal object UserFactory {

    private val names = arrayOf("Alan", "Arthur", "Nicolas", "Angela", "Brenda", "Liz")
    private val desc = arrayOf(
        "Lorem ipsum",
        "Veni vidi vici",
        "Quis custodiet ipsos custodes?",
        "parva scintilla excitavit magnum incendium"
    )

    fun makeUser() = UserModel(
        names[getRandomValue(0, names.size)],
        desc[getRandomValue(0, desc.size)],
        getRandomValue(18, 40)
    )

    private fun getRandomValue(low: Int, high: Int): Int {
        return Random().nextInt(high - low) + low
    }
}
