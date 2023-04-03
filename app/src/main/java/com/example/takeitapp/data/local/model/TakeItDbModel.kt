package com.example.takeitapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_publication")
data class TakeItDbModel(
    @PrimaryKey(autoGenerate = true)
    val publicationId: Long? = null,
    val title: String,
    val imageUrl: String,
    val description: String,
    val address: String,
    val number: String,
)
