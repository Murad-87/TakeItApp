package com.mytakeitapp.feature_add_publication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AddPublicationEntity(
    val publicationId: Long? = null,
    var title: String,
    var imageUrl: String,
    var description: String,
    var address: String,
    var number: String
) : Parcelable
