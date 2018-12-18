package com.giffter.bestgift.domain.entity

import java.util.*

data class Gift(
        val id: String = UUID.randomUUID().toString(),
        val title: String = "title"
)