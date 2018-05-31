package com.example.pagingandroid.repository

import com.example.pagingandroid.api.BookService
import com.example.pagingandroid.model.Book
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookRepository {

    private val bookService = builder.build().create(BookService::class.java)

    private val builder: Retrofit.Builder
        get() = Retrofit.Builder()
                .baseUrl("http://assignment.gae.golgek.mobi/api/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())

    fun getListBook(offset: Long): Single<List<Book>>{
        return bookService.getBook(offset = offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}