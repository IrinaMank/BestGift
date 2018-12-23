package com.giffter.bestgift.ui.filterlist

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.giffter.bestgift.R
import com.giffter.bestgift.domain.entity.Gift
import com.giffter.bestgift.domain.presenter.filterlist.FilterListPresenter
import com.giffter.bestgift.domain.presenter.filterlist.FilterListView
import com.giffter.bestgift.ui.gifts_recycler.GiftAdapter
import kotlinx.android.synthetic.main.fragment_gift_list.*
import org.koin.android.ext.android.inject

class FilterListFragment : MvpAppCompatFragment(), FilterListView {

    @InjectPresenter
    lateinit var presenter: FilterListPresenter

    val presKoin: FilterListPresenter by inject()

    @ProvidePresenter
    fun providePresenter(): FilterListPresenter {
        return presKoin
    }

    override fun showProgress(show: Boolean) {
        if (show)
            progressbar.visibility = View.VISIBLE
        else progressbar.visibility = View.GONE
    }

    override fun hideSwipeProgress() {
    }


    override fun showGifts(gifts: List<Gift>) {
        adapterGifts.items = gifts
        adapterGifts.notifyDataSetChanged()
    }

    private val adapterGifts: GiftAdapter by lazy {
        GiftAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_gift_list, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(list) {
            layoutManager =  LinearLayoutManager(context)

            adapter = adapterGifts
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(columnCount: Int) =
                FilterListFragment()
    }
}
