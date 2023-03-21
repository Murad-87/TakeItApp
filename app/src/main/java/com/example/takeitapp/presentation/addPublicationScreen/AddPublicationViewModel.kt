package com.example.takeitapp.presentation.addPublicationScreen

import androidx.lifecycle.ViewModel
import com.example.takeitapp.domain.SavePublicationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddPublicationViewModel @Inject constructor(
    private val savePublicationUseCase: SavePublicationUseCase
) : ViewModel() {

//    fun saveData() {
//        viewModelScope.launch {
//            savePublicationUseCase.invoke()
//        }
//    }
}