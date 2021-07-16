package com.seanpeters.domain.repository

import com.seanpeters.domain.entities.Volume
import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    suspend fun getRemoteBooks(author:String):Result<List<Volume>>
    suspend fun getBookmarks(): Flow<List<Volume>>
}