package com.example.feature_home.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_home.domain.model.TestMoviesEntity
import com.example.feature_home.domain.use_case.GetAllPublicationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetAllPublicationUseCase
) : ViewModel() {

    private val _allMovies = MutableStateFlow<List<TestMoviesEntity>>(emptyList())
    val allMovies: StateFlow<List<TestMoviesEntity>>
        get() = _allMovies.asStateFlow()

    init {
        getAllMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch {
            runCatching {
                useCase.invoke()
            }.onSuccess { moviesList ->
                _allMovies.value = moviesList
            }.onFailure { throwable ->
                error(throwable)
            }
        }
    }
}