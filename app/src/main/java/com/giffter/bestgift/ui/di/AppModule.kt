package com.giffter.bestgift.ui.di

import android.content.Context
import android.system.Os.bind
import com.giffter.bestgift.data.GiftApiRepository
import com.giffter.bestgift.domain.presenter.AllGiftsPresenter
import com.giffter.bestgift.domain.presenter.filter.FilterPresenter
import io.reactivex.schedulers.Schedulers.single
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val appModule = module {

        single { GiftApiRepository()}
        single { AllGiftsPresenter(get()) }
        single { FilterPresenter(get()) }

}