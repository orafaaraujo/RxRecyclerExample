package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.viewholder

import android.view.View
import android.widget.ImageButton
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.orafaaraujo.rxrecyclerexample.R

class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var title: TextView = itemView.findViewById(R.id.main_card_title)

    var desc: TextView = itemView.findViewById(R.id.main_card_desc)

    var moreButton: ImageButton = itemView.findViewById(R.id.main_card_more)

    var deleteButton: ImageButton = itemView.findViewById(R.id.main_card_delete)
}
