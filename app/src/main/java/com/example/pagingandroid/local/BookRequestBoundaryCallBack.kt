package com.example.pagingandroid.local

import android.arch.paging.PagedList
import com.example.pagingandroid.model.Book
import com.example.pagingandroid.usecase.BookUsecase

class BookRequestBoundaryCallBack: PagedList.BoundaryCallback<Book>(){


    override fun onItemAtEndLoaded(lastBook: Book) {
        super.onItemAtEndLoaded(lastBook)

        BookUsecase().requestBookNext(lastBook.bookId + 20)
    }
}