package com.example.takeitapp.presentation.registrationScreen

import androidx.lifecycle.ViewModel
import com.example.takeitapp.domain.repository.TakeItRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: TakeItRepository
) : ViewModel() {
}