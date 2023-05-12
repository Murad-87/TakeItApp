package com.mytakeitapp.feature_user_publication.domain.use_case

import com.mytakeitapp.feature_user_publication.domain.model.UserPublicationEntity
import com.mytakeitapp.feature_user_publication.domain.repository.TakeItUserPublicationRepository
import javax.inject.Inject

class DeletePublicationUserUseCase @Inject constructor(
    private val repository: TakeItUserPublicationRepository
) {

    suspend operator fun invoke(item: UserPublicationEntity) =
        repository.deletePublicationUser(item)

}