package com.seanpeters.data.repositories

import com.seanpeters.domain.entities.Volume

interface BooksRemoteDataSource {
    suspend fun getBooks(author:String): Result<List<Volume>>
}