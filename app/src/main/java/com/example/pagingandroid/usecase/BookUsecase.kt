package com.example.pagingandroid.usecase

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.pagingandroid.PagingApplication
import com.example.pagingandroid.local.BookDao
import com.example.pagingandroid.local.BookRequestBoundaryCallBack
import com.example.pagingandroid.model.Book
import com.example.pagingandroid.repository.BookRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BookUsecase{

    @Inject
    lateinit var bookDao: BookDao

    init {
        PagingApplication.appComponent.inject(this)
    }

    fun requestBook(){
        BookRepository.getListBook(0).subscribe({
            bookDao.insertBook(it)
        },{
            println(it.message)
        })
    }

    fun requestBookNext(offset: Long){
        BookRepository.getListBook(offset).subscribe({
            bookDao.insertBook(it)
        },{
            println(it.message)
        })
    }

    fun getPageListBook(): LiveData<PagedList<Book>>{
        return LivePagedListBuilder(bookDao.getListBook(), PagedList.Config.Builder()
                .setPageSize(20)
                .setEnablePlaceholders(true)
                .build())
                .setBoundaryCallback(BookRequestBoundaryCallBack())
                .build()
    }
}