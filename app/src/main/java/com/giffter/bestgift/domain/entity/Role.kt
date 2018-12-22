package com.giffter.bestgift.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

enum class Role(val displayedName: String, val serverName: String) {

    FRIEND("Друг", "m.friend"),
    FAMILIAR("Знакомый", "m.familiar"),
    COLLEAGUE("Коллега", "m.colleague"),
    PARENT("Родитель", "m.parent"),
    SISOBRO("Сестра/Брат", "m.sisobro"),
    GRANDPARENT("Бабушка/дедушка", "m.grangparent"),

    CLOSERELATIVE("Близкий родственник", "m.closerelative"),

    NONCLOSERELATIVE("Дальний родственник", "m.noncloserelative");

    companion object {
        fun getValueOf(value: String): Role?
                = Role.values().find{ it.displayedName == value }
    }
}