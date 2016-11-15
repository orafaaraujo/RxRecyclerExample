package com.orafaaraujo.rxrecyclerexample.presentation.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.main_fab)
    FloatingActionButton mFab;

    @BindView(R.id.main_recycler)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupView();
        setupRecycler();

    }

    private void setupView() {
        setSupportActionBar(mToolbar);
        mFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Observable
                .range(1, 5)
                .zipWith(Observable.interval(200, TimeUnit.MILLISECONDS), (Func2<Integer, Long, Object>) (integer, aLong) -> integer)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> ((RecyclerAdapter) mRecyclerView.getAdapter()).updateList(o));

    }

    private void setupRecycler() {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());

        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new RecyclerAdapter(this, new ArrayList<>(0)));
    }


}
