package com.giffter.bestgift.domain.presenter.filterlist

import com.arellomobile.mvp.MvpView
import com.giffter.bestgift.domain.entity.Gift

interface FilterListView: MvpView {


    fun showProgress(show: Boolean)
    fun hideSwipeProgress()
    fun showGifts(gifts: List<Gift>)

}