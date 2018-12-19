package com.giffter.bestgift.domain.entity

enum class Occasion(val displayedName: String) {

    BIRTHDAY("c.dob"),
    NEW_YEAR("c.ny"),
    WOMAN_DAY("c.8m"),
    MAN_DAY("c.23f"),
    VALENTINE_DAY("c.14f"),
    WEDDING("c.wedding"),
    WEDDING_ANNIV("c.wedding_anniversary"),
    BABY_BIRTH("c.happy_event"),
    GIRL_PARTY("c.hen-party"),
    BOY_PARTY("c.stag-party"),
    HOUSEWARMING("c.housewarming"),
}