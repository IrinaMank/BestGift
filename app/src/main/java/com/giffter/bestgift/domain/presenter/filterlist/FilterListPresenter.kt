package com.giffter.bestgift.domain.presenter.filterlist

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.giffter.bestgift.data.GiftApiRepository

@InjectViewState
class FilterListPresenter(
        private val repo: GiftApiRepository
) : MvpPresenter<FilterListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

//        repo.getAllGifts()
//                .doOnSubscribe { viewState.showProgress(true) }
//                .doAfterTerminate { viewState.showProgress(false) }
//                .subscribe(
//                        {
//                            viewState.showGifts(it)
//                        },
//                        {
//                            viewState.hideSwipeProgress()
//                        }
//                )
    }

}