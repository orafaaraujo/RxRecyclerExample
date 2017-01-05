package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.orafaaraujo.rxrecyclerexample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void linearVertical(View view) {
        startActivity(new Intent(this, LinearLayoutActivity.class));
    }

    public void horizontalVertical(View view) {
        startActivity(new Intent(this, LinearLayoutHorizontalActivity.class));
    }

    public void grid(View view) {
        startActivity(new Intent(this, GridLayoutActivity.class));
    }

    public void staggredGrid(View view) {
        startActivity(new Intent(this, StaggeredGridLayoutActivity.class));
    }

}
