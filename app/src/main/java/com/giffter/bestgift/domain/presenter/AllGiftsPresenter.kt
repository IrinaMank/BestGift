package com.giffter.bestgift.domain.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.giffter.bestgift.data.GiftApiRepository

@InjectViewState
class AllGiftsPresenter(
        private val repo: GiftApiRepository
) : MvpPresenter<AllGiftsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        repo.getAllGifts()
                .doOnSubscribe { viewState.showProgress(true) }
                .doAfterTerminate { viewState.showProgress(false) }
                .subscribe(
                        {
                            viewState.showGifts(it)
                        },
                        {
                            viewState.hideSwipeProgress()
                        }
                )
    }

    fun onClick() {}

}