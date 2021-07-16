package com.seanpeters.domain.usecases

import com.seanpeters.domain.repository.BooksRepository

class GetBookmarksUseCase( private val booksRepository: BooksRepository){
    suspend operator fun invoke() = booksRepository.getBookmarks()
}