package com.example.pagingandroid.vm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.example.pagingandroid.model.Book
import com.example.pagingandroid.usecase.BookUsecase

class MainViewModel: ViewModel(){

    var listBook: LiveData<PagedList<Book>>
    private val bookUsecase = BookUsecase()

    init {
        bookUsecase.requestBook()
        listBook = bookUsecase.getPageListBook()
    }
}