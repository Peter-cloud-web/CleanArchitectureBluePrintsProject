package com.seanpeters.domain.usecases

import com.seanpeters.domain.entities.Volume
import com.seanpeters.domain.repository.BooksRepository

class UnBookMarkUseCase(val booksRepository: BooksRepository) {
    suspend fun invoke(book:Volume) = booksRepository.unbookmark(book)
}