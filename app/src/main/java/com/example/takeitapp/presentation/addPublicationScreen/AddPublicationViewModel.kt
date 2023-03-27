package com.example.takeitapp.presentation.addPublicationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takeitapp.domain.SavePublicationUseCase
import com.example.takeitapp.domain.model.TakeItEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPublicationViewModel @Inject constructor(
    private val savePublicationUseCase: SavePublicationUseCase
) : ViewModel() {

    fun saveData(dataEntity: TakeItEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            savePublicationUseCase.invoke(dataEntity)
        }
    }
}