package com.giffter.bestgift.domain.presenter

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.giffter.bestgift.domain.entity.Gift

@StateStrategyType(AddToEndSingleStrategy::class)
interface AllGiftsView : MvpView {

    fun showProgress(show: Boolean)
    fun hideSwipeProgress()
    fun showGifts(gifts: List<Gift>)

}