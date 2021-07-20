package com.seanpeters.data.mappers

import com.seanpeters.data.entities.BooksEntity
import com.seanpeters.domain.entities.Volume
import com.seanpeters.domain.entities.VolumeInfo

class BookEntityMapper {

    fun toBookEntity(volume: Volume):BooksEntity{
         return BooksEntity(
             id = volume.id,
             title = volume.volumeInfo.title,
             authors = volume.volumeInfo.authors,
             imageUrl = volume.volumeInfo.imageUrl
         )

    }

    fun toVolume(booksEntity: BooksEntity):Volume{
        return Volume(
            booksEntity.id,
            VolumeInfo(booksEntity.title,booksEntity.authors,booksEntity.imageUrl)
        )
    }
}