package com.giffter.bestgift.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

enum class Gender(val displayedName: String) {

    @JsonProperty("s.m")
    MAN("s.m"),

    @JsonProperty("s.f")
    WOMAN("s.f"),

}