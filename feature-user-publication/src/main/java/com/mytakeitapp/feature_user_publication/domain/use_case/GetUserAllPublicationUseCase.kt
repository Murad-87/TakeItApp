package com.mytakeitapp.feature_user_publication.domain.use_case

import com.mytakeitapp.feature_user_publication.domain.repository.TakeItUserPublicationRepository
import javax.inject.Inject

class GetUserAllPublicationUseCase @Inject constructor(
    private val repository: TakeItUserPublicationRepository
) {
    fun getAllPublicationUser() = repository.getUserAllPublication()
}