package com.giffter.bestgift.domain.entity

import java.util.*

data class Gift(
        val id: String = UUID.randomUUID().toString(),
        val title: String = "title",
        val occasion: List<String> = emptyList(),
        val gender: List<String> = emptyList(),
        val role: List<String> = emptyList(),
        val ageFrom: Int = 0,
        val ageTo: Int = 99
)