package com.giffter.bestgift.ui.gifts_recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.giffter.bestgift.R
import com.giffter.bestgift.domain.entity.Gift
import kotlin.properties.Delegates

class GiftAdapter() : RecyclerView.Adapter<GiftViewHolder>() {

    var items: List<Gift> by Delegates.observable(arrayListOf()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GiftViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiftViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gift, parent,
                false)
        return GiftViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

//    fun removeAt(position: Int) {
//        items.removeAt(position)
//        notifyItemRemoved(position)
//    }
//
//    fun clearItems() {
//        items.clear()
//        notifyDataSetChanged()
//    }


}

