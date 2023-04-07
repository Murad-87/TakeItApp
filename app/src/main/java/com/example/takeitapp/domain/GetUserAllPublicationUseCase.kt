package com.example.takeitapp.domain

import com.example.takeitapp.domain.repository.TakeItRepository
import javax.inject.Inject

class GetUserAllPublicationUseCase @Inject constructor(
    private val repository: TakeItRepository
) {
    fun getAllPublicationUser() = repository.getUserAllPublication()
}