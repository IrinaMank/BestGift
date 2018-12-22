package com.giffter.bestgift.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

enum class Gender(val displayedName: String, val serverName: String) {

    MAN("Мужской","s.m"),
    WOMAN("Женский","s.f");

    companion object {
        fun getValueOf(value: String): Gender?
                = Gender.values().find{ it.displayedName == value }
    }

}