package com.mytakeitapp.feature_user_publication.domain.use_case

import com.mytakeitapp.feature_user_publication.domain.repository.TakeItUserPublicationRepository
import javax.inject.Inject

class GetDetailInfoPublicationUseCase @Inject constructor(
    private val repository: TakeItUserPublicationRepository
) {
    suspend operator fun invoke() = repository.getDetailInfoPublication()
}