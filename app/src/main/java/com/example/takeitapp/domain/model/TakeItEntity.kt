package com.example.takeitapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TakeItEntity(
    val publicationId: Long,
    val title: String,
    val imageUrl: String,
    val description: String,
    val address: String,
    val number: String
) : Parcelable
