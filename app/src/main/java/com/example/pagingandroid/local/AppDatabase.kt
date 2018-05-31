package com.example.pagingandroid.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.pagingandroid.model.Book

@Database(entities = [(Book::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun taskDao(): BookDao
}
