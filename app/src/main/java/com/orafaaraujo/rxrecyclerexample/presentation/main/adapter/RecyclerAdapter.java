package com.orafaaraujo.rxrecyclerexample.presentation.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.MainActivity;
import com.orafaaraujo.rxrecyclerexample.presentation.main.adapter.viewholder.LineHolder;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 15/11/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<UserModel> mUsers;


    public RecyclerAdapter(MainActivity activity, ArrayList users) {
        mUsers = users;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_line_view, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.title.setText(mUsers.get(position).getName());
        holder.itemView.setOnClickListener(view -> {
            updateItem(position);
        });
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void updateList(UserModel user) {
        insertItem(user, 0);
    }

    private void insertItem(UserModel user, Integer position) {
        mUsers.add(position, user);
        notifyItemInserted(position);
    }

    private void updateItem(int position) {
    }

    private void removerItem(int position) {
        mUsers.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mUsers.size());
    }
}


