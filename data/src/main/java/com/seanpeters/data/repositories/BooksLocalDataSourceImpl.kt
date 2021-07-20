package com.seanpeters.data.repositories

import com.seanpeters.data.db.BooksDao
import com.seanpeters.data.mappers.BookEntityMapper
import com.seanpeters.domain.entities.Volume
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class BooksLocalDataSourceImpl(
    private val booksDao:BooksDao,
    private val dispatcher: CoroutineDispatcher,
    private val bookEntityMapper: BookEntityMapper
    ): BooksLocalDataSource{
    override suspend fun bookmark(book: Volume) = withContext(dispatcher) {
        booksDao.getSavedBooks(bookEntityMapper.toBookEntity(book))
    }

    override suspend fun unbookmark(book: Volume) = withContext(dispatcher) {
        booksDao.deleteBook(bookEntityMapper.toBookEntity(book))
    }

    override suspend fun getBookmarks(): Flow<List<Volume>> {
        val savedBooksFlow = booksDao.getSavedBooks()
        return savedBooksFlow.map{ list ->
            list.map{ element ->
                bookEntityMapper.toVolume(element)

            }

        }
    }

}