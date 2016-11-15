package com.orafaaraujo.rxrecyclerexample.presentation.main.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.orafaaraujo.rxrecyclerexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rafael on 15/11/16.
 */

public class LineHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.main_line_title)
    public TextView title;

    public LineHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
