package com.example.takeitapp.presentation.allPublicationUserScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takeitapp.domain.GetUserAllPublicationUseCase
import com.example.takeitapp.domain.model.TakeItEntity
import com.example.takeitapp.domain.repository.TakeItRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllPublicationUserViewModel @Inject constructor(
    private val getUserAllPublicationUseCase: GetUserAllPublicationUseCase,
    private val repository: TakeItRepository
) : ViewModel() {

    private val _allPublicationUser = MutableStateFlow<List<TakeItEntity>>(emptyList())
    val allPublicationUser: StateFlow<List<TakeItEntity>>
        get() = _allPublicationUser.asStateFlow()

    init {
        getAllPublicationUser()
    }

    private fun getAllPublicationUser() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = getUserAllPublicationUseCase.getAllPublicationUser()
            _allPublicationUser.emitAll(data)
        }
    }

    fun deletePublication(item: TakeItEntity) {
        viewModelScope.launch {
            repository.deletePublicationUser(item)
        }
    }
}