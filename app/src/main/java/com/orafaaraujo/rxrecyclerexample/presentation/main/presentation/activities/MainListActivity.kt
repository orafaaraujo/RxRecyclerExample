package com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.orafaaraujo.rxrecyclerexample.presentation.main.presentation.adapter.OldCardAdapter
import com.orafaaraujo.rxrecyclerexample.presentation.main.repository.UserFactory
import kotlinx.android.synthetic.main.activity_main_list.*

class MainListActivity : AppCompatActivity() {

    private val adapterOld: OldCardAdapter = OldCardAdapter(mutableListOf())

    private val manager = StaggeredGridLayoutManager(COUNT, StaggeredGridLayoutManager.VERTICAL)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.orafaaraujo.rxrecyclerexample.R.layout.activity_main_list)

        setupView()
    }

    private fun setupView() {
        recycler_view_layout_recycler.layoutManager = manager
        recycler_view_layout_recycler.adapter = adapterOld

        recycler_view_layout_fab.setOnClickListener {
            val model = UserFactory.makeUser()
            adapterOld.updateList(model)
        }
    }

    companion object {

        private const val COUNT = 3
    }
}
