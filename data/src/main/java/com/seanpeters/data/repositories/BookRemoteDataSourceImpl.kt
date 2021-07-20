package com.seanpeters.data.repositories

import com.seanpeters.data.api.BooksApi
import com.seanpeters.data.mappers.BookApiResponseMapper
import com.seanpeters.domain.entities.Volume
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BookRemoteDataSourceImpl(
    private val service:BooksApi,
    private val mapper:BookApiResponseMapper
):BooksRemoteDataSource {
    override suspend fun getBooks(author: String): Result<List<Volume>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getBooks(author)
                if (response.isSuccessful) {
                    return@withContext Result.success(mapper.toVolumeList(response.body()!!))
                } else {
                    return@withContext Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }

}