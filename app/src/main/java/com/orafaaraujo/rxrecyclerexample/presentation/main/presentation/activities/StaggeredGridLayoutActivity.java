package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.UserModel;
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.CardAdapter;
import com.orafaaraujo.rxrecyclerexample.presentation.main.repository.UserLoader;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StaggeredGridLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.recycler_view_layour_fab)
    FloatingActionButton mFab;

    @BindView(R.id.recycler_view_layour_recycler)
    RecyclerView mRecyclerView;

    private CardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_layout);

        ButterKnife.bind(this);

        setupView();
        setupRecycler();
    }

    private void setupView() {
        mFab.setOnClickListener(this);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onClick(View view) {
        UserLoader
                .fetch()
                .subscribe(o -> mAdapter.updateList((UserModel) o));
    }

    private void setupRecycler() {

        // Criando o StaggeredGridLayoutManager com duas colunas, descritas no primeiro argumento
        // e no sentido vertical (como uma lista).
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        mAdapter = new CardAdapter(new ArrayList<>(0));
        mRecyclerView.setAdapter(mAdapter);
    }
}
