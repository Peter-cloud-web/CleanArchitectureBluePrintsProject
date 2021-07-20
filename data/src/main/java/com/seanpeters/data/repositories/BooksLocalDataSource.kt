package com.seanpeters.data.repositories

import com.seanpeters.domain.entities.Volume

interface BooksLocalDataSource {
    suspend fun bookmark(book: Volume)
    suspend fun unbookmark(book: Volume)
    suspend fun getBookMarks():Flow<List<Volume>>
}