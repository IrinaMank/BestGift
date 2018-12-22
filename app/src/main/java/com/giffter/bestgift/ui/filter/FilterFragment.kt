package com.giffter.bestgift.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItemsMultiChoice
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.giffter.bestgift.R
import com.giffter.bestgift.domain.entity.Gender
import com.giffter.bestgift.domain.entity.Occasion
import com.giffter.bestgift.domain.entity.Role
import com.giffter.bestgift.domain.presenter.filter.FilterPresenter
import com.giffter.bestgift.domain.presenter.filter.FilterView
import com.giffter.bestgift.ui.filterlist.FilterListFragment
import kotlinx.android.synthetic.main.fragment_filter.*
import org.koin.android.ext.android.inject

class FilterFragment : MvpAppCompatFragment(), FilterView {

    var selectedItems = emptyList<String>()

    @InjectPresenter
    lateinit var presenter: FilterPresenter

    val presKoin: FilterPresenter by inject()

    @ProvidePresenter
    fun providePresenter(): FilterPresenter {
        return presKoin
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_filter, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val occasssions = Occasion.values().map {it.displayedName}
        val roles = Role.values().map {it.displayedName}

        occasion_btn.setOnClickListener {
            MaterialDialog(context!!).show {

                listItemsMultiChoice(items = occasssions) { dialog, indices, items ->
                    presenter.occasions = items.map { Occasion.getValueOf(it) }
                }
                positiveButton(R.string.find_btn)
            }
        }

        role_btn.setOnClickListener {
            MaterialDialog(context!!).show {

                listItemsMultiChoice(items = roles) { dialog, indices, items ->
                    presenter.roles = items.map { Role.getValueOf(it) }
                }
                positiveButton(R.string.find_btn)
            }
        }

        filter_btn.setOnClickListener {
            val genders = mutableListOf<Gender>()
            if (woman.isChecked) genders.add(Gender.WOMAN)
            if (man.isChecked) genders.add(Gender.MAN)

            presenter.gender = genders

            presenter.ageFrom = rangebar.leftIndex
            presenter.ageTo = rangebar.rightIndex

            presenter.getGifts()
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_container,
                    FilterListFragment.newInstance(1))
                    .addToBackStack(null)
                    .commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() =
                FilterFragment()
    }
}
