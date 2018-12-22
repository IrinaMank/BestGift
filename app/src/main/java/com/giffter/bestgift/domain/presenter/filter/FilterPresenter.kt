package com.giffter.bestgift.domain.presenter.filter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.giffter.bestgift.data.GiftApiRepository
import com.giffter.bestgift.domain.entity.Gender
import com.giffter.bestgift.domain.entity.Gift
import com.giffter.bestgift.domain.entity.Occasion
import com.giffter.bestgift.domain.entity.Role
import io.reactivex.subjects.BehaviorSubject

@InjectViewState
class FilterPresenter(
        private val repo: GiftApiRepository
) : MvpPresenter<FilterView>() {

    var occasions: List<Occasion?> = emptyList()
    var roles: List<Role?> = emptyList()
    var gender: List<Gender?> = emptyList()

    var ageFrom = 0
    var ageTo = 99

    var filteredList = BehaviorSubject.create<List<Gift>>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()


    }

    fun getGifts() = repo.getAllGifts()
            .map {
                it.filter {
                    it.occasion.any { occassion -> occasions.map { it?.serverName }.contains(occassion)} &&
                            it.role.any { role -> roles.map { it?.serverName }.contains(role)} &&
                            it.gender.any { gender.map { it?.serverName }.contains(it) } &&
                            it.ageFrom <= ageFrom && it.ageTo >= ageTo
                }
            }
            .subscribe(
                    {
                        filteredList.onNext(it)
                    },
                    {

                    }
            )
}