package com.example.takeitapp.presentation.allPublicationUserScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takeitapp.domain.GetUserAllPublicationUseCase
import com.example.takeitapp.domain.model.TakeItEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllPublicationUserViewModel @Inject constructor(
    private val getUserAllPublicationUseCase: GetUserAllPublicationUseCase
) : ViewModel() {

    private val _allPublicationUser = MutableStateFlow<List<TakeItEntity>>(emptyList())
    val allPublicationUser: StateFlow<List<TakeItEntity>>
        get() = _allPublicationUser.asStateFlow()

    init {
        getAllPublication()
    }

    private fun getAllPublication() {
        viewModelScope.launch {
            runCatching {
                getUserAllPublicationUseCase.invoke()
            }.onSuccess {publicationList ->
                _allPublicationUser.value = publicationList
            }.onFailure {throwable ->
                error(throwable)
            }
        }
    }
}