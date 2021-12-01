package com.example.utu.data.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.utu.data.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val itemList = MutableLiveData<List<Item>>()
    private val topList = MutableLiveData<List<Toppost>>()
    private val eduList = MutableLiveData<List<Edutip>>()
    private val nftList = MutableLiveData<List<Nfttip>>()
    private val creatorList = MutableLiveData<List<Creator>>()
    private val mediaList = MutableLiveData<List<Media>>()

    const val TAG = "RetrofitInstance"

    private val retrofitBuilder: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.jsonbin.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitApi: RetrofitApi = retrofitBuilder.create(RetrofitApi::class.java)

    fun getItemData(): MutableLiveData<List<Item>> {

        Log.d(TAG, "inside getItemData()")
        val retrofitCall = retrofitApi.getItems()

        retrofitCall.enqueue(object : Callback<Item> {
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                Log.d(TAG, "inside onResponse()")

                val body = response.body()

                Log.v(TAG, "$body")

            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                Log.d(TAG, "inside onFailure()")
            }

        })

        return itemList
    }
}