package com.mytakeitapp.feature_user_publication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserPublicationEntity(
    val publicationId: Long? = null,
    var title: String,
    var imageUrl: String,
    var description: String,
    var address: String,
    var number: String
): Parcelable
