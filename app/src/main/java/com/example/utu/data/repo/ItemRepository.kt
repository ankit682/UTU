package com.example.utu.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.utu.data.api.RetrofitInstance
import com.example.utu.data.model.Item

class ItemRepository {

    fun getItem(): MutableLiveData<List<Item>> {
        return RetrofitInstance.getItemData()
    }
}