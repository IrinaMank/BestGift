package com.giffter.bestgift.domain.entity

enum class Occasion(val displayedName: String, val serverName: String) {

    BIRTHDAY("День рождения", "c.dob"),
    NEW_YEAR("Новый год","c.ny"),
    WOMAN_DAY("8 Марта","c.8m"),
    MAN_DAY("23 февраля","c.23f"),
    VALENTINE_DAY("День Влюбленных","c.14f"),
    WEDDING("Свадьба","c.wedding"),
    WEDDING_ANNIV("Годовщина свадьбы","c.wedding_anniversary"),
    BABY_BIRTH("Рождение ребенка","c.happy_event"),
    GIRL_PARTY("Девичник","c.hen-party"),
    BOY_PARTY("Мальчишник","c.stag-party"),
    HOUSEWARMING("Новоселье","c.housewarming");

    companion object {
        fun getValueOf(value: String): Occasion?
                = Occasion.values().find{ it.displayedName == value }
    }
}

