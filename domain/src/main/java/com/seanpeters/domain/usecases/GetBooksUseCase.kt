package com.seanpeters.domain.usecases

import com.seanpeters.domain.repository.BooksRepository

class GetBooksUseCase(private val booksRepository: BooksRepository) {

    suspend fun invoke(author:String) = booksRepository.getRemoteBooks(author)
}