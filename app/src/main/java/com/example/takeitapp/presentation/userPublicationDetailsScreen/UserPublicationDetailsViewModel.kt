package com.example.takeitapp.presentation.userPublicationDetailsScreen

import androidx.lifecycle.ViewModel
import com.example.takeitapp.domain.repository.TakeItRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserPublicationDetailsViewModel @Inject constructor(
    private val repository: TakeItRepository
) : ViewModel() {
}