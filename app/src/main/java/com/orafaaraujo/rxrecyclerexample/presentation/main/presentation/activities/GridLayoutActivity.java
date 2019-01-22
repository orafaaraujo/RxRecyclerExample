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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class GridLayoutActivity extends AppCompatActivity implements View.OnClickListener {
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

        // Criando o GridLayoutManager com duas colunas, descritas no segundo argumento.
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        mAdapter = new CardAdapter(new ArrayList<>(0));
        mRecyclerView.setAdapter(mAdapter);
    }
}
