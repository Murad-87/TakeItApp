package com.example.takeitapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TakeItEntity(
    val publicationId: Long? = null,
    var title: String,
    var imageUrl: String,
    var description: String,
    var address: String,
    var number: String
) : Parcelable
