package com.mytakeitapp.feature_add_publication.domain.use_case


import com.mytakeitapp.feature_add_publication.domain.model.AddPublicationEntity
import com.mytakeitapp.feature_add_publication.domain.repository.TakeItAddPublicationRepository
import javax.inject.Inject

class SavePublicationUseCase @Inject constructor(
    private val repository: TakeItAddPublicationRepository
) {
    suspend operator fun invoke(list: AddPublicationEntity) = repository.savePublication(list)
}