package com.mytakeitapp.feature_user_publication.presentation.allPublicationUserScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mytakeitapp.feature_user_publication.domain.model.UserPublicationEntity
import com.mytakeitapp.feature_user_publication.domain.use_case.DeletePublicationUserUseCase
import com.mytakeitapp.feature_user_publication.domain.use_case.GetUserAllPublicationUseCase
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
    private val deletePublicationUserUseCase: DeletePublicationUserUseCase
) : ViewModel() {

    private val _allPublicationUser = MutableStateFlow<List<UserPublicationEntity>>(emptyList())
    val allPublicationUser: StateFlow<List<UserPublicationEntity>>
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

    fun deletePublication(item: UserPublicationEntity) {
        viewModelScope.launch {
            deletePublicationUserUseCase.invoke(item)
        }
    }
}