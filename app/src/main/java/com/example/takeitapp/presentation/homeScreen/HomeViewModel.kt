package com.example.takeitapp.presentation.homeScreen

import androidx.lifecycle.ViewModel
import com.example.takeitapp.domain.repository.TakeItRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TakeItRepository
) : ViewModel() {
}