package com.example.takeitapp.presentation.allPublicationUserScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takeitapp.domain.GetUserAllPublicationUseCase
import com.example.takeitapp.domain.model.TakeItEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllPublicationUserViewModel @Inject constructor(
    private val getUserAllPublicationUseCase: GetUserAllPublicationUseCase
) : ViewModel() {

    private val _allPublicationUser: MutableLiveData<List<TakeItEntity>> = MutableLiveData()
    val allPublicationUser: LiveData<List<TakeItEntity>> get() = _allPublicationUser

    fun getAllPublication() {
        viewModelScope.launch {  }
    }
}