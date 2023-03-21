package com.example.takeitapp.domain

import com.example.takeitapp.domain.repository.TakeItRepository
import javax.inject.Inject

class GetDetailInfoPublicationUseCase @Inject constructor(
    private val repository: TakeItRepository
) {
    suspend operator fun invoke() = repository.getDetailInfoPublication()
}