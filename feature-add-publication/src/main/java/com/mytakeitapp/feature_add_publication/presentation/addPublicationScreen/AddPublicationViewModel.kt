package com.mytakeitapp.feature_add_publication.presentation.addPublicationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytakeitapp.feature_add_publication.domain.model.AddPublicationEntity
import com.mytakeitapp.feature_add_publication.domain.use_case.SavePublicationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPublicationViewModel @Inject constructor(
    private val savePublicationUseCase: SavePublicationUseCase
) : ViewModel() {

    fun insertData(dataEntity: AddPublicationEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            savePublicationUseCase.invoke(dataEntity)
        }
    }
}