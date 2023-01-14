package com.example.android.amphibiansapp.ui.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.amphibiansapp.data.repository.interfaces.AmphibianRepository
import com.example.android.amphibiansapp.data.response.Amphibian
import com.example.android.amphibiansapp.data.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AmphibianViewModel @Inject constructor(
    private val repository: AmphibianRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun loadAmphibians() = viewModelScope.launch {
        when (val result = repository.fetchAmphibianData()) {
            is Resource.Error -> updateStateError()
            is Resource.Success -> updateStateSuccess(result.data ?: emptyList())
        }
    }

    private fun updateStateError() {
        _uiState.update {
            it.copy(
                state = ResourceState.ERROR
            )
        }
    }

    private fun updateStateSuccess(amphibians: List<Amphibian>) {
        _uiState.update {
            it.copy(
                state = ResourceState.SUCCESS,
                amphibians = amphibians
            )
        }
    }
}
