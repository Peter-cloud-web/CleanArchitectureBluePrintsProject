package com.seanpeters.data.mappers

import com.seanpeters.data.api.BooksApiResponse
import com.seanpeters.domain.entities.Volume
import com.seanpeters.domain.entities.VolumeInfo

class BookApiResponseMapper {

    fun toVolumeList(response:BooksApiResponse):List<Volume>{
        return response.item.map {
            Volume(
                id = it.id, VolumeInfo(
                    it.volumeInfo.title,
                    it.volumeInfo.authors,
                    it.volumeInfo.imageLinks?.thumbnail?.replace("http", "https")
                )

            )
        }
    }
}