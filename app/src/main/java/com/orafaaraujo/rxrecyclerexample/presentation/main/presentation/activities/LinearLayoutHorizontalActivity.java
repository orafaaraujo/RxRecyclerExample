package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.UserModel;
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.RecyclerAdapter;
import com.orafaaraujo.rxrecyclerexample.presentation.main.repository.UserFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class LinearLayoutHorizontalActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.recycler_view_layour_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.recycler_view_layour_fab)
    FloatingActionButton mFab;

    @BindView(R.id.recycler_view_layour_recycler)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_layour);

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
                .range(1, 8)
                .zipWith(Observable.interval(200, TimeUnit.MILLISECONDS),
                        (Func2<Integer, Long, Object>) (integer, aLong) -> UserFactory.makeUser())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o ->
                        ((RecyclerAdapter) mRecyclerView.getAdapter()).updateList((UserModel) o));
    }

    private void setupRecycler() {

        // Para criar um layout de uma lista.
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Divisor entre Views! Passando a orientação como paramêtro do DividerItemDecoration.
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new RecyclerAdapter(new ArrayList<>(0)));
    }
}
