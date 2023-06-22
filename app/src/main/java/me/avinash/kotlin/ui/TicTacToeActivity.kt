package me.avinash.learn.kotlin.coroutines.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.avinash.kotlin.RecyclerData
import me.avinash.kotlin.RecyclerViewAdapter


class TicTacToeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var recyclerDataArrayList: ArrayList<RecyclerData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(me.avinash.learn.kotlin.coroutines.R.layout.activity_tic_tac_toe)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(me.avinash.learn.kotlin.coroutines.R.id.recyclerView)

        // added data to array list
        val grid = 3
        for (i in 1..(grid*grid)) {
            recyclerDataArrayList.add(RecyclerData(-1))
        }

        // added data from arraylist to adapter class.

        // added data from arraylist to adapter class.
        val adapter = RecyclerViewAdapter(
            recyclerDataArrayList,
            this@TicTacToeActivity
        )

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.

        // setting grid layout manager to implement grid view.
        // in this method '3' represents number of columns to be displayed in grid view.
        val layoutManager = GridLayoutManager(this, 3)

        // at last set adapter to recycler view.

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.setAdapter(adapter)
    }
}