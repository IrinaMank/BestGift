package com.giffter.bestgift.domain.presenter.filterlist

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.giffter.bestgift.data.GiftApiRepository
import com.giffter.bestgift.domain.entity.Gift
import com.giffter.bestgift.domain.presenter.filter.FilterPresenter
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.inject

@InjectViewState
class FilterListPresenter(
        private val repo: GiftApiRepository,
        private val presenter: FilterPresenter
) : MvpPresenter<FilterListView>() {

    private var filterdList = presenter.filteredList

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        filterdList.subscribe {
            viewState.showGifts(it)
        }


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