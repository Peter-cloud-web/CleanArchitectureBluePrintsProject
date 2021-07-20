package com.seanpeters.data.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seanpeters.data.entities.BooksEntity

interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBook(book: BooksEntity)

    @Query("SELECT * FROM book")
    fun getSavedBooks(): Flow<List<BooksEntity>>

    @Delete
    suspend fun deleteBook(book: BooksEntity)
}