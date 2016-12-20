package com.orafaaraujo.rxrecyclerexample.presentation.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.orafaaraujo.rxrecyclerexample.R;
import com.orafaaraujo.rxrecyclerexample.presentation.main.adapter.RecyclerAdapter;
import com.orafaaraujo.rxrecyclerexample.presentation.main.model.UserModel;
import com.orafaaraujo.rxrecyclerexample.presentation.main.repository.UserFactory;

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

    private RecyclerView.LayoutManager mLayoutManager;

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
                .range(1, 8)
                .zipWith(Observable.interval(200, TimeUnit.MILLISECONDS),
                        (Func2<Integer, Long, Object>) (integer, aLong) -> UserFactory.makeUser())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o ->
                        ((RecyclerAdapter) mRecyclerView.getAdapter()).updateList((UserModel) o));

    }

    private void setupRecycler() {

        createList();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new RecyclerAdapter(new ArrayList<>(0)));
    }

    /**
     * Este método irá criar um layout semelhante à uma lista.
     */
    private void createList() {

        // Para criar um layout simples como uma lista, basta passar o Contexto.
        mLayoutManager = new LinearLayoutManager(this);

        // Divisor entre Views! Passando a orientação como paramêtro do DividerItemDecoration.
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    /**
     * Este método irá criar um layout de lista horizontal, onde os conteúdos ficarão lado-a-lado.
     */
    private void createHorizontalList() {

        // Para criar um layout de uma lista.
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Divisor entre Views! Passando a orientação como paramêtro do DividerItemDecoration.
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
    }

    /**
     * Este método irá criar um layout de Grid(como uma grade).
     */
    private void createGridLayoutManager() {

        // Criando o GridLayoutManager com duas colunas, descritas no segundo argumento.
        mLayoutManager = new GridLayoutManager(this, 2);

        // Divisor entre views! Como é no formate de grade, precisamos dela em ambas orientações.
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    /**
     * Este método irá criar um layout de Grid, porém, as views ficarão escalonavéis, de acordo
     * com o seu tamanho..
     */
    private void createStaggeredGridLayoutManager() {

        // Criando o StaggeredGridLayoutManager com duas colunas, descritas no primeiro argumento
        // e no sentido vertical (como uma lista).
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        // Divisor entre views.
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }


}
