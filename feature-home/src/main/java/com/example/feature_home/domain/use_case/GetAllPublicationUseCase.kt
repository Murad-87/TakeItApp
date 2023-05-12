package com.example.feature_home.domain.use_case

import com.example.feature_home.domain.repository.TakeItHomeRepository
import javax.inject.Inject

class GetAllPublicationUseCase @Inject constructor(
    private val repository: TakeItHomeRepository
) {
    suspend operator fun invoke() = repository.getAllPublication()
}