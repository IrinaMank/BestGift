package com.giffter.bestgift.data

import io.reactivex.Single
import java.util.*

interface GiftApiInterface<T> {

    fun getAllGifts(): Single<List<T>>
}