package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.viewholder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.orafaaraujo.rxrecyclerexample.R;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rafael on 15/11/16.
 */

public class LineHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.main_line_title)
    public TextView title;

    @BindView(R.id.main_line_more)
    public ImageButton moreButton;

    @BindView(R.id.main_line_delete)
    public ImageButton deleteButton;

    public LineHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
