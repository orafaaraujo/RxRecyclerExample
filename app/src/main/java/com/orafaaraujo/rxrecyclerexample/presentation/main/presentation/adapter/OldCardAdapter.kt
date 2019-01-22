package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orafaaraujo.rxrecyclerexample.R
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.UserModel
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.viewholder.CardHolder
import java.util.Locale

class OldCardAdapter(private val users: MutableList<UserModel>) :
    RecyclerView.Adapter<CardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        return CardHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_card_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.title.text = String.format(
            Locale.getDefault(), "%s, %d",
            users[position].name,
            users[position].age
        )
        holder.desc.text = users[position].description
        holder.moreButton.setOnClickListener { updateItem(position) }
        holder.deleteButton.setOnClickListener { removerItem(position) }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    private fun insertItem(user: UserModel) {
        users.add(user)
        notifyItemInserted(itemCount)
    }

    private fun updateItem(position: Int) {
        users[position].incrementAge()
        notifyItemChanged(position)
    }

    private fun removerItem(position: Int) {
        users.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, users.size)
    }

    fun updateList(user: UserModel) {
        insertItem(user)
    }
}


