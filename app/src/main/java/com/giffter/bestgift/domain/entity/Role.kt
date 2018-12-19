package com.giffter.bestgift.domain.entity

import com.fasterxml.jackson.annotation.JsonProperty

enum class Role(val displayedName: String) {

    @JsonProperty("m.friend")
    FRIEND("m.friend"),

    @JsonProperty("m.familiar")
    FAMILIAR("m.familiar"),

    @JsonProperty("m.colleague")
    COLLEAGUE("m.colleague"),

    @JsonProperty("m.parent")
    PARENT("m.parent"),

    @JsonProperty("m.sisobro")
    SISOBRO("m.sisobro"),

    @JsonProperty("m.grangparent")
    GRANDPARENT("m.grangparent"),

    @JsonProperty("m.closerelative")
    CLOSERELATIVE("m.closerelative"),

    @JsonProperty("m.noncloserelative")
    NONCLOSERELATIVE("m.noncloserelative"),
}