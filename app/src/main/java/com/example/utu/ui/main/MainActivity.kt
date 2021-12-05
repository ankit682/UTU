package com.example.utu.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.utu.R
import com.example.utu.data.model.Item
import com.example.utu.ui.adapter.ItemAdapter
import com.example.utu.viewmodels.ItemViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var itemViewModel: ItemViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        Log.e("TAG", " in Main Activity")

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.hasFixedSize()

        itemViewModel = ViewModelProvider(this)[ItemViewModel::class.java]

        itemViewModel.getItem().observe(this, Observer<List<Item>> { itemList ->
            Log.e("TAG", " in Main Obserever ${itemList[0].feedType}")
            recyclerView.adapter = ItemAdapter(itemList as ArrayList<Item>, context)
            recyclerView.adapter?.notifyDataSetChanged()
            Log.e("TAG", " in Main Obserever ${itemList.size}")
        })
    }
}