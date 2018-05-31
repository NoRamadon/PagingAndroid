package com.example.pagingandroid.local

import android.arch.paging.DataSource
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.example.pagingandroid.model.Book

@Dao interface BookDao {

    @Query("select * from Book order by bookId")
    fun getListBook():  DataSource.Factory<Int, Book>

    @Insert(onConflict = IGNORE)
    fun insertBook(book: List<Book>)

    @Query("delete from Book")
    fun resetBook()
}