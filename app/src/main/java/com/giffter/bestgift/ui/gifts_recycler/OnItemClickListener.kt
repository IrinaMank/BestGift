package com.giffter.bestgift.ui.gifts_recycler

import com.giffter.bestgift.domain.entity.Gift


interface OnItemClickListener {
    fun onItemClick(gift: Gift)
}