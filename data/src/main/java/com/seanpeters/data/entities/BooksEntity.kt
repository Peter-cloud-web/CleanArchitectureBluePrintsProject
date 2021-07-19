package com.seanpeters.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class BooksEntity(
    @PrimaryKey
    val id:String,
    val title:String,
    val authors:List<String>,
    val imageUrl:String
)