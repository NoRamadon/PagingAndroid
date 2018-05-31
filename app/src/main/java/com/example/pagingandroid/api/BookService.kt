package com.example.pagingandroid.api

import com.example.pagingandroid.model.Book
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface BookService {

    @GET("items?")
    fun getBook(@Query("count") count: String = "20",
                @Query("offset") offset: Long): Single<List<Book>>
}