package com.giffter.bestgift.ui.filter

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.listItemsMultiChoice
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.giffter.bestgift.R
import com.giffter.bestgift.domain.entity.Gift
import com.giffter.bestgift.domain.entity.Role
import com.giffter.bestgift.domain.presenter.filter.FilterPresenter
import com.giffter.bestgift.domain.presenter.filter.FilterView
import com.giffter.bestgift.ui.AllGiftFragment
import com.giffter.bestgift.ui.gifts_recycler.GiftAdapter
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
        val myItems = listOf("c.dob")

        occasion_btn.setOnClickListener {
            MaterialDialog(context!!).show {

                listItemsMultiChoice(items = myItems) { dialog, indices, items ->
                    presenter.occasions = items
                    presenter.getGifts()
                }
                positiveButton(R.string.app_name)
            }
        }

        val roles = Role.values().map { it.displayedName }.toList()

        role_btn.setOnClickListener {
            MaterialDialog(context!!).show {

                listItemsMultiChoice(items = roles) { dialog, indices, items ->
                    selectedItems = items
                }
                positiveButton(R.string.app_name)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
                FilterFragment()
    }
}
