package com.giffter.bestgift.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
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
import com.giffter.bestgift.domain.entity.presenter.AllGiftsPresenter
import com.giffter.bestgift.domain.entity.presenter.AllGiftsView
import com.giffter.bestgift.ui.gifts_recycler.GiftAdapter
import org.koin.android.ext.android.inject


/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [AllGiftFragment.OnListFragmentInteractionListener] interface.
 */
class AllGiftFragment : MvpAppCompatFragment(), AllGiftsView {

    @InjectPresenter
    lateinit var presenter: AllGiftsPresenter

    val presKoin: AllGiftsPresenter by inject()

    @ProvidePresenter fun providePresenter(): AllGiftsPresenter {
return presKoin
    }


    override fun showProgress(show: Boolean) {

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


        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager =  LinearLayoutManager(context)
                
                adapter = adapterGifts
            }
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(columnCount: Int) =
                AllGiftFragment()
    }
}
