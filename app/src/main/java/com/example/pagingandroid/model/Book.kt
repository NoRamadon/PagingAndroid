package com.example.pagingandroid.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Book", indices = arrayOf(Index(value = ["id"], unique = true)))
data class Book(
        val id: Long,
        val title: String,
        val price: Float,
        val link: String) {
    @PrimaryKey(autoGenerate = true)
    var bookId: Long = 0
}