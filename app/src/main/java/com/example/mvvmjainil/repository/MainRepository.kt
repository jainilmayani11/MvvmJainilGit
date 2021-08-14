package com.example.mvvmjainil.repository

import com.example.mvvmjainil.api.RetrofitService
import retrofit2.Response
import retrofit2.Retrofit

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}