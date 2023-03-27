package com.example.takeitapp.domain

import com.example.takeitapp.domain.model.TakeItEntity
import com.example.takeitapp.domain.repository.TakeItRepository
import javax.inject.Inject

class SavePublicationUseCase @Inject constructor(
    private val repository: TakeItRepository
) {
    suspend operator fun invoke(list: TakeItEntity) = repository.savePublication(list)
}