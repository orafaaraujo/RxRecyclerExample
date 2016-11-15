package com.orafaaraujo.rxrecyclerexample.presentation.main.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.MainActivity;
import com.orafaaraujo.rxrecyclerexample.presentation.main.adapter.viewholder.LineHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 15/11/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<String> mTitles;

    private final Activity mActivity;

    public RecyclerAdapter(MainActivity activity, ArrayList titles) {
        mTitles = titles;
        mActivity = activity;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_line_view, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.title.setText(mTitles.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitles != null ? mTitles.size() : 0;
    }

    public void updateList(Object newItem) {
        mTitles.add(mActivity.getString(R.string.item_number, newItem));
        notifyItemInserted(mTitles.size());
    }
}


