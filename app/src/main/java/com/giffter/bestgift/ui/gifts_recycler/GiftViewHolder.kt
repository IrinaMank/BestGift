package com.giffter.bestgift.ui.gifts_recycler

import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.giffter.bestgift.domain.entity.Gift
import kotlinx.android.synthetic.main.item_gift.view.*


class GiftViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(gift: Gift) {


        itemView.apply {
tv_element_title.text = gift.title
//            Glide.with(this)
//                    .load(gift.photo.url)
//                    .apply(RequestOptions()
//                            .centerCrop()
//                            .placeholder(R.drawable.profile_icon)
//                            .error(R.drawable.profile_icon).dontAnimate())
//                    .into(this.iv_element)
//
//            tv_element_type.text = TypesConverter.getStringFromType(gift.type, itemView.context)
//            tv_element_date.text = gift.date
//            tv_element_user.text = gift.user.nickname
//            tv_element_user.paintFlags = tv_element_user.paintFlags or Paint
//                    .UNDERLINE_TEXT_FLAG or Paint.ANTI_ALIAS_FLAG
//            tv_element_is_found.text = if (gift.isFound) {
//                context.getString(R.string
//                        .pet_is_found)
//            } else {
//                context.getString(R.string.pet_not_found)
//            }
//            if (!gift.isPublished) {
//                tv_element_is_published.visibility = View.VISIBLE
//            }
//            if (gift.isFavorite) {
//                favor_checkbox.isChecked = true
//            }
        }

        itemView.setOnClickListener {  }
    }
}

