package com.example.takeitapp.domain

import com.example.takeitapp.domain.repository.TakeItRepository
import javax.inject.Inject

class GetAllPublicationUseCase @Inject constructor(
    private val repository: TakeItRepository
) {
    suspend operator fun invoke() = repository.getAllPublication()
}