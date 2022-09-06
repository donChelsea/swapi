package com.example.swapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swapi.data.repository.CharacterRepository
import com.example.swapi.domain.Character
import com.example.swapi.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = CharacterRepository()

    private val _uiState  = MutableStateFlow(MainUiState.Success(emptyList()))
    val uiState : StateFlow<MainUiState> = _uiState

    init {
        viewModelScope.launch {
            repository.getCharacters().collect { characters ->
                _uiState.value = MainUiState.Success(characters)
            }
        }
    }
}

sealed class MainUiState {
    data class Success(val data: List<Character>): MainUiState()
    data class Error(val message: String): MainUiState()
}