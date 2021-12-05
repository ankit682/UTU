package com.example.utu.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.utu.data.model.Item
import com.example.utu.data.repo.ItemRepository

class ItemViewModel : ViewModel() {

    private val itemRepository = ItemRepository()

    fun getItem(): MutableLiveData<List<Item>> {
        Log.e("TAG","inside getItem()")
        return itemRepository.getItem()
    }
}