package com.example.utu.data.api

import com.example.utu.data.model.Item
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {

    @GET("/b/61a17e6e0ddbee6f8b128130")
    fun getItems(): Call<Item>
}