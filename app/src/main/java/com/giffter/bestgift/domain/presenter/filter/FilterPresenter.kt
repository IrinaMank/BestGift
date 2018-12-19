package com.giffter.bestgift.domain.presenter.filter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.giffter.bestgift.data.GiftApiRepository
import com.giffter.bestgift.domain.entity.Occasion

@InjectViewState
class FilterPresenter(
        private val repo: GiftApiRepository
) : MvpPresenter<FilterView>() {

    var occasions: List<String> = emptyList()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()


    }

    fun getGifts() = repo.getAllGifts()
            .map {
                it.filter {
                    it.occasion.containsAll(occasions)
                }
            }
            .subscribe(
                    {
                        2+2
                    },
                    {
                        2+2
                    }
            )
}