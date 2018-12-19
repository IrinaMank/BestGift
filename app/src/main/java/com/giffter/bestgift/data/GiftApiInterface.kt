package com.giffter.bestgift.data

import io.reactivex.Single
import java.util.*

interface GiftApiInterface<T> {

    fun getAllGifts(): Single<List<T>>

    fun getFilteredGifts(occassion: List<String>, role: List<String>, gender: List<String>,
                         ageFrom: Int, ageTo: Int): Single<List<T>>
}