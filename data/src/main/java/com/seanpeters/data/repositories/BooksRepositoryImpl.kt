package com.seanpeters.data.repositories

import com.seanpeters.domain.entities.Volume
import com.seanpeters.domain.repository.BooksRepository

class BooksRepositoryImpl(
    private val localDataSource: BooksLocalDataSource,
    private val remoteDataSource: BooksRemoteDataSource
) : BooksRepository{
    override suspend fun getRemoteBooks(author: String): Result<List<Volume>> {
        return remoteDataSource.getBooks(author)
    }

    override suspend fun getBookmarks(): Flow<List<Volume>> {
        return localDataSource.getBookMarks()
    }

    override suspend fun bookmark(book: Volume) {
        localDataSource.bookmark(book)
    }


    override suspend fun unbookmark(book: Volume) {
        localDataSource.unbookmark(book)
    }
}